==================
Java 7 on Mac OS X
==================

.. note::

  Note: I'm generally a fan of Apple and own many of their products.  My primary computer is a MacBook Pro, which I wouldn't trade for anything.  But Apple has really screwed this one up.

Apple has hurt its users who develop in Java by declaring an end to Java support but continuing to update Java 6 using its automatic update program.  This means that installing Oracle Java 7 JDK is a hassle to begin with, and if you blindly accept all of Apple's software updates (that is, you don't remember to uncheck Java updates when they appear)  you'll have to re-do parts of your Java 7 installation from time to time because Apple's Java updates reset all the symlinks to point to its own Java 6.  In any case, here's what you need to do to install and use Java 7 on Mac OS X and fix Apples "updates" if they slip by you.  At the time of this writing the current Java 7 is update 17 (jdk1.7.0_17).

New: 

First Time Java 7 Installation
==============================

Get the Java 7 JDK (not JRE) from here: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html.  You want the Mac OS X x64 download (I couldn't provide a direct link becuase the page I linked in the previous sentence requires you to accept a license agreement).  It's a .dmg (disk image) containing a package installer.  Double click the package installer, enter your password when prompted, and your new Java 7 JDK will be installed in a few minutes.  Kind of.  This step only places the JDK on your hard disk.  Now you have to set a few symlinks so that you can actually use it.

.. note::

  To understand the remaining steps you need to understand that Mac OS X is a Unix operating system, and you have to know a little Unix to get certain things done.  You may want to read some background_ information first.


Figuring Out if You Have Apple's Java 6
=======================================

Apple installs its JDK in ``/System/Library/Java/JavaVirtualMachines``.  If you have Apple's JDK and the symlinks are set up for it, perhaps after you've followed these instructions but then allowed Apple's Software Update to install a Java update, you can find out with ``java -version`` or by seeing where the symlink at ``usr/bin/java`` points.  If ``java -version`` prints something like "Java 1.6" (the important part being the "1.6") or the symlink at ``usr/bin/java`` points to ``/System/Library/Java/JavaVirtualMachines`` (note that Apple installs under ``/System/Library``, Oracle installs under ``/Library``), then you need to follow the rest of these instructions.

If you use an older version of Java, like Apple's Java 6 and try to write programs that use Java class files that were compiled with a newer version of Java you may see an error like this:

.. code-block:: bash

  warning: ./Location.class: major version 51 is newer than 50, the highest major version supported by this compiler.
  It is recommended that the compiler be upgraded.

This message means you're using Java 1.6 (version 50) with pre-compiled ``.class`` files that were compiled with Java 1.7 (version 51).  In general, you can use the Java disassembler, ``javap`` to find out which version of Java was used to compile a class:

.. note::

  Note: the '$' character is the shell prompt.  In the example shell interactions in this guide, the commands you type will appear after a shell prompt.

.. code-block:: bash

  $ javap -verbose Location.class | head
  Classfile /Users/chris/Downloads/PacmanSkeleton/Location.class
    Last modified Mar 8, 2013; size 1241 bytes
    MD5 checksum 2e22b98aa3c1fb2bb3a06e5cd4f2fd24
    Compiled from "Location.java"
  public class Location
    SourceFile: "Location.java"
    minor version: 0
    major version: 51
    flags: ACC_PUBLIC, ACC_SUPER
  Constant pool:

Note that I piped the output of ``javap -verbose`` through ``head`` because it prints a ton of information.

Removing Apple's Java 6
-----------------------

.. note::

  You don't have permission on the directories that contain the JDK and the system's ``java`` command.  So you'll need to execute your commands that modify these directories as the ``root`` user, a.k.a. the superuser.  You can do that on a per-command basis by prepending your commands with ``sudo``.  These instructions have ``sudo`` prepended, so you can simply copy and paste them into your command line.  Note that ``sudo`` will ask you for your password and it will not be echoed as you type it.  Just type it and press ENTER.

Remove Apple's JVMs:

.. code-block:: bash

  $ sudo rm -rf /System/Library/Java/JavaVirtualMachines/

Remove installer records:

.. code-block:: bash

  $ sudo rm /private/var/db/receipts/com.apple.pkg.JavaForMacOSX*

Remove intaller receipts by editing ``/Library/Receipts/InstallHistory.plist`` and removing any ``<dict>...</dict>`` entries that contain references to Apple's Java.  You can recognize these dict entries because they'll have child elements that contain ``com.apple``.  You can leave Oracle's installation receipts alone.  It's a bit tedious editing this file.  I found the dict elements by searching for ``ava``.  Note that you'll need to edit this file as the superuser, for example by doing:

.. code-block:: bash

  $ sudo emacs /Library/Receipts/InstallHistory.plist

Once you've removed all these traces of Apple's Java 6 install, Apple's software update should not (re)install Java 6 and you should only need to reset your symlinks when you install a new JDK from Oracle.


Setting The Symlinks for Java 7
===============================

.. code-block:: bash

  $ sudo rm /usr/bin/java
  $ sudo ln -s /Library/Java/JavaVirtualMachines/jdk1.7.0_17.jdk/Contents/Home/bin/java /usr/bin/java

That's it!  Now you should get this:

.. code-block:: bash

  $ java -version
  java version "1.7.0_17"
  Java(TM) SE Runtime Environment (build 1.7.0_17-b02)
  Java HotSpot(TM) 64-Bit Server VM (build 23.7-b01, mixed mode)
  $ javac -version
  javac 1.7.0_17

Optional: JAVA_HOME
-------------------

Some Java software, like Tomcat, require that you set an environment variable named ``JAVA_HOME``.  The convention in Mac OS X is to make a symlink named ``/Library/Java/Home`` and assign it to your ``JAVA_HOME`` environment variable.  That way you don't have to remember to update your ``JAVA_HOME`` environment variable when you install a new JDK, but you do have to update the symlink.  The following assumes you already have a ``/Library/Java/Home`` symlink (Apple's installer used to set it, I think.  Maybe it still does.)

.. code-block:: bash

  $ sudo rm /Library/Java/Home
  $ sudo ln -s /Library/Java/JavaVirtualMachines/jdk1.7.0_17.jdk/Contents/Home /Library/Java/Home

.. _background:

Background - The PATH, Symbolic Links, and the Unix Directory Tree
==================================================================


The Terminal
------------

Apple provides a fairly decent terminal emulator in /Applications/Terminal.app.  Go ahead and put this in your dock.  If you're a CS major, you'll use it every day.  Terminal provides you with command shell known as BASH (Bourne Again Shell).  A shell is a program that allows a user to interact directly with the operating system.  You're already familiar with graphical shells that include things like file explorers, start menus, and control panels.  Command line shells, at least the ones on Unix, are far more powerful than graphical shells, so you need to learn one, and BASH is by far the most popular.  The rest of these instructions are BASH commands that take place in Terminal.

The PATH
--------

Unix (and Windows) maintains a set of global variables accessible to all programs called *environment variables*. You can get a list of them with the ``env`` command (I've only shown a few interesting ones here):

.. code-block:: bash

  $ env
  TERM_PROGRAM=Apple_Terminal
  SHELL=/bin/bash
  PATH=/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/usr/local/bin
  JAVAFX_HOME=/Library/Java/Home
  PWD=/System/Library/Java
  JAVA_HOME=/Library/Java/Home
  PS1=\[\033[32;1m\][\u@\h \w]\n$ \[\033[0m\]
  HOME=/Users/chris
  LOGNAME=chris

The important environment variable to note for now is the PATH variable.  The PATH variable contains a colon-separated list of directory paths that contain executable files (commands).  When you type a command at the shell prompt, the directories in PATH are searched for a match.  You can find out exactly which executable file will be executed in response to a particular command with the ``which`` command:

.. code-block:: bash

  $ which java
  /usr/bin/java


As you can see, the ``java`` command on Mac OS X is contained in the ``/usr/bin`` directory, but its a symbolic link to the actual locatoin of the ``java`` executable.  You can see this by getting a "long" directory listing of it (the ``-l`` switch to the ``ls`` command gives detailed info about directory entries).

.. code-block:: bash

  $ ls -l /usr/bin/java
  lrwxr-xr-x  1 root  wheel  72 Mar 13 23:36 /usr/bin/java -> /Library/Java/JavaVirtualMachines/jdk1.7.0_17.jdk/Contents/Home/bin/java

That "->" in the directory listing means it's a symbolic link.

Symbolic Links
--------------

A link is a pointer to a file or a directory, kind of like a reference variable.  A hard link is a directory entry that points to a file on disk.  Every file has (at least) one hard link.  A symbolic link, or soft link, is a directory entry that points to a hard link, like an alias.  You create symbolic links with the ``ln -s`` command.  (You can also create hard links, but don't.)  When you remove the last hard link to a file, you can no longer access the file.  This is what generally happens when you delete a file.  The directory entry for it (hard link) is gone, but the contents remain on disk until they are overwritten.  When you delete a directory entry that's a symlink, only the symlink is gone.  The file and its hard link remain.

Here's a simple example.  We create a text file named ``foo.txt`` containing the text "bar" and a symlink to ``foo.txt`` named ``baz.txt``.  The general form of the ``ln -s`` command is ``ln -s <hard-link> <soft-link>``.

.. code-block:: bash

  $ echo "bar" > foo.txt
  $ cat foo.txt 
  bar
  $ ln -s foo.txt baz.txt
  $ ls -l
  total 16
  lrwxr-xr-x  1 chris  staff  7 Mar 13 22:46 baz.txt -> foo.txt
  -rw-r--r--  1 chris  staff  4 Mar 13 22:45 foo.txt
  $ cat baz.txt 
  bar

As you can see, the symbolic link acts just like the original hard link.

The Unix File System
--------------------

The Unix file system is organized as a tree.  There is a root directory, ``/``, and a tree of directories under ``/`` [1]_.  Just like in other operating systems' file systems, every directory entry has an owner, a group, and access permissions.  The important thing you need to know for now is that you don't have permission on the directories that contain the JDK and the system's ``java`` command.  So you'll need to execute your commands that modify these directories as the ``root`` user, a.k.a. the superuser.  You can do that on a per-command basis by prepending your commands with ``sudo``.  These instructions have ``sudo`` prepended, so you can simply copy and paste them into your command line.  Note that ``sudo`` will ask you for your password and it will not be echoed as you type it.  Just type it and press ENTER.

.. [1] The Windows file system is organized as a forrest with possibly multiple roots at ``C:\``, ``D:\``, and so on.  Windows directories are also tightly bound to disk partitions, i.e., ``C:\`` and ``D:\`` are the roots of filesystems on  different disk partitions.
