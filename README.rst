Course Materials for Introduction to OOP in Java
================================================

This project contains the course materials I use for the Introduction to Object-Oriented Programming course at Georgia Tech, CS 1331.  Feel free to use them if you want.

Requirements
------------

To use this repository you'll need

- LaTeX with beamer, and some other packages
- Python Docutils, http://docutils.sourceforge.net/index.html
- SBT (optional)

Contents
--------

slides/
  The latex sources for lecture slides

guides/
  reStructuredTex sources for HTML guides

code/
  Source code used in lectures

syllabus/
  reStructuredTex sources for course syllabi

project/
  The SBT project directory

Using SBT
---------

SBT is the Scala Build Tool (officially it's *Simple* Build Tool, but calling it simple is so absurd that I refuse to do it).  If you install SBT on your system you'll be able to use some targets that I wrote for SBT:

slides
  Runs pdflatex on the slides

clean
  Cleans the latex output form the slides directory

syllabus
  Runs rst2html.py on the syllabi in syllabus/

guides
  Runs rst2html.py on the guides in guides/

upload
  Uploads the output files (html, pdf) from slides/, guides/, and syllabus/, and the code from code/ to the (web) server specified in upload-info.txt

upload-info.txt
~~~~~~~~~~~~~~~

To use the upload task, create a file named ``upload-info.txt`` in the project root directory.  The file should contain exacly three lines:

.. code-block::
  
  username
  host
  directory

``username`` is your username on the ``host`` server, and ``directory`` is the directory to which you want to upload your course materials.
