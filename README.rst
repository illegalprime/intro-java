Course Materials for Introduction to OOP in Java
================================================

This project contains the course materials I use for the Introduction to Object-Oriented Programming course at Georgia Tech, CS 1331.  Feel free to use them if you want.

Requirements
------------

To use this repository you'll need

- LaTeX with beamer, and some other packages (which are all in MacTeX_)
- Python_ for Docutils_
- Docutils_ for reStructuredText_
- SBT_ (optional)

Contents
--------

slides/
  The LaTeX sources for lecture slides

guides/
  reStructuredText_ sources for HTML guides

code/
  Source code used in lectures

syllabus/
  reStructuredText_ sources for course syllabi

project/
  The SBT_ project directory

Using SBT
---------

SBT_ is the Scala Build Tool (officially it's *Simple* Build Tool, but calling it simple is so absurd that I refuse to do it).  If you install SBT_ on your system you'll be able to use some targets that I wrote for SBT:

slides
  Runs ``pdflatex`` on the slides

clean
  Cleans the latex output from the ``slides/`` directory

syllabus
  Runs ``rst2html.py`` on the syllabi in ``syllabus/``

guides
  Runs ``rst2html.py`` on the guides in ``guides/``

upload
  Uploads the output files (html, pdf) from slides/, guides/, and syllabus/, and the code from code/ to the (web) server specified in upload-info.txt

upload-info.txt
~~~~~~~~~~~~~~~

To use the upload task, create a file named ``upload-info.txt`` in the project root directory.  The file should contain exacly three lines:

.. code-block::
  
  username
  host.cs.myschool.edu
  ~username/my/course/dir/

``username`` is your username on the ``host`` server, and the last line is the directory to which you want to upload your course materials.

Note: the uplaod task uses scp for each file.  I highly recommend
adding your public key to the ~/.ssh/authorized_keys file on your
server so you don't have to type your password several times.

.. _MacTeX: http://tug.org/mactex/
.. _Python: http://www.python.org/
.. _Docutils: http://docutils.sourceforge.net/
.. _reStructuredText: http://docutils.sourceforge.net/rst.html
.. _SBT: http://www.scala-sbt.org/
