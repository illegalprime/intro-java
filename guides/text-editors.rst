==================================================
Introduction to Text Editors for Young Programmers
==================================================

.. figure:: http://imgs.xkcd.com/comics/regular_expressions.png
   :align: center
   :width: 480
   
   From http://xkcd.com/208/

Text is the raw material of the craft of programming.  You should become good at manipulating text.  The first thing you should do is pick a good cross-platform text editor and learn it well.  If you haven't already done so, this guide will help you choose one.  The next thing you should do is learn regular expressions, and the next thing after that is learn UNIX and one of its command shells, probably bash.

Choosing a text editor
======================

I use Emacs, but it has a steep learning curve.  If you want something you'll be productive with quickly try `Sublime Text 2`_ or jEdit_ .  Many people who insist on using Windows like `Notepad++`_.

But if you're going to get a computer science or engineering degree, you might as well learn Emacs_ or Vim_, the two major editors available on every UNIX platform, Windows, and Mac.  Vim is probably easier.  I'll post tutorials for these soon.

.. tip::

   - On Mac OS X the best way to get Emacs is EmacsForOSX_.  Aquamacs is too different from standard GNU Emacs without providing compelling benefits, and has non-standard configuration.  I tried Aquamacs for a couple of weeks and it annoyed the hell out of me.  For example, I couldn't get it to stop turning on auto-fill-mode in text-based major modes.


Customizing your text editor
============================

Having a go-to text editor improves your productivity in part because it will be set up with your preferred defaults.  Customization is important because many text editors and IDEs are configured with bad defaults.  Good programmers insist on writing code that is clear and consistently formatted.  Having a well-configured text editor helps you do that.

TABS Versus Spaces
------------------

Never use TABs in source code.  Always indent with spaces.  The traditional meaning of TAB is to move the cursor to the next multiple of tab width (8 by the Java spec).  If you adopt, as most programming teams do, the convention of using spaces for all indentation and alignment (no TAB characters anywhere), then "tabbing" means inserting the required number of spaces to get to a multiple of tab width.  Since the Java code convention doesn't specify whether TAB characters or spaces are used for indentation, and that indentation should be 4 spaces, and that tabs be set every 8 spaces, it allows for an absurd case where a programmer using a feature-poor editor would be forced to hit the space bar 4 times when indenting to the first level of indentation.  Of course modern editors take care of these sorts of details, but most programmers completely eschew TAB characters to avoid such issues and to ensure that code looks consistent in any editor or display no matter how the tabs are set.  And most programmers set their editors to insert spaces for tabs.  Jamie Zawinski, a famous Emacs, Mozilla and Netscape hacker, has an informative write-up here: http://www.jwz.org/doc/tabs-vs-spaces.html



.. Links

.. _Emacs: http://www.gnu.org/software/emacs/
.. _Vim: http://www.vim.org/
.. _EmacsForOSX: http://emacsformacosx.com/

.. _`Sublime Text 2`: http://www.sublimetext.com/2
.. _jEdit: http://www.jedit.org/
.. _`Notepad++`: http://notepad-plus-plus.org/
