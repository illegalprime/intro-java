import sbt._
import sbt.Keys._
import sys.process._

object CourseMaterials extends Build {
  
  lazy val root = Project(id = "coursematerials",
    base = file("."),
    settings = Project.defaultSettings ++
      Seq(slidesTask, cleanTask, syllabusTask, guidesTask, uploadTask))

  val slidesTaskKey = TaskKey[Unit]("slides", "Make slides from latex sources.")
  val cleanTaskKey = TaskKey[Unit]("clean", "Clean latex and java output.")
  val syllabusTaskKey = TaskKey[Unit]("syllabus", "Make syllabi from rst sources.")
  val guidesTaskKey = TaskKey[Unit]("guides","Make resources from rst sources.")
  val uploadTaskKey = TaskKey[Unit]("upload", "Upload course materials to web site.")

  val slidesTask = slidesTaskKey := {
    val latexFilter = new FileFilter() {
      def accept(f: File) = f.getName().endsWith(".tex")
    }
    val latexFiles = new File("slides/").listFiles(latexFilter).map(_.getName())
    println("Making slides from sources: " + latexFiles.mkString(","))
    for (f <- latexFiles) {
      val p = sys.process.Process("pdflatex " + f, new File("slides/"))
      p !
    }
  }

  val cleanTask = cleanTaskKey := {
    val deleteFilter = new FileFilter() {
      def accept(f: File) = 
        f.getName().endsWith(".aux") ||
        f.getName().endsWith(".fls") ||
        f.getName().endsWith(".log") ||
        f.getName().endsWith(".nav") ||
        f.getName().endsWith(".out") ||
        f.getName().endsWith(".pdf") ||
        f.getName().endsWith(".snm") ||
        f.getName().endsWith(".toc") ||
        f.getName().endsWith(".vrb")
    }
    val deleteFiles = new File("slides/").listFiles(deleteFilter)
    for (f <- deleteFiles) f.delete()
  }

  val syllabusTask = syllabusTaskKey := {
    val rstFilter = new FileFilter() {
      def accept(f: File) = f.getName().endsWith(".rst")
    }
    val rstFiles = new File("syllabus/").listFiles(rstFilter).map(_.getName())
    println("Making syllabi from sources: " + rstFiles.mkString(","))
    for (f <- rstFiles) {
      val p = sys.process.Process("rst2html.py " + f + " " + 
        f.substring(0, f.lastIndexOf("."))+".html" , new File("syllabus/"))
      p !
    }
  }

  val guidesTask = guidesTaskKey := {
    val rstFilter = new FileFilter() {
      def accept(f: File) = f.getName().endsWith(".rst")
    }
    val rstFiles = new File("guides/").listFiles(rstFilter).map(_.getName())
    println("Making guides from sources: " + rstFiles.mkString(","))
    for (f <- rstFiles) {
      val p = sys.process.Process("rst2html.py " + f + " " + 
        f.substring(0, f.lastIndexOf("."))+".html" , new File("guides/"))
      p !
    }
  }

  val uploadTask = uploadTaskKey := {
    val fileLines = io.Source.fromFile("upload-info.txt").getLines()
    val user = fileLines.next().trim()
    val host = fileLines.next().trim()
    val dir = fileLines.next().trim()
    val scpDest = user + "@" + host + ":" + dir

    upload("slides/", ".pdf", scpDest)
    upload("guides/", ".html", scpDest)
    upload("code/", ".java", scpDest)
    upload("code/", ".txt", scpDest)
    upload("code/", ".csv", scpDest)
    upload("code/", ".data", scpDest)
    upload("syllabus/", ".html", scpDest)
  }

  def upload(srcDir: String, fileEnding: String, scpDest: String) {
    val filter = new FileFilter() {
      def accept(f: File) = f.getName().endsWith(fileEnding)
    }
    val files = new File(srcDir).listFiles(filter).map(_.getName())
    println("Uploading: " + files.mkString(","))
    for (f <- files) {
      val scpString = "scp " + f + " " + scpDest + srcDir
      println("Executing: " + scpString)
      val p = sys.process.Process(scpString, new File(srcDir))
      p !
    }
  }
}
