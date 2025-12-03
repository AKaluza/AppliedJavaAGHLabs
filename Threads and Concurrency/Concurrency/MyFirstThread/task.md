Thread Introduction
-

There is nothin to do. Go through the files

- ThreadSubclass.java
- ThreadAnonymous.java
- MyRunnable.java
- MyRunnableAnonymous.java
- LambdaImplementationOfRunnable.java

and read about different way how to 
deal with threads.

Thread Subclass
-
The first way to specify what code a thread 
is to run, is to create a subclass of 
Thread and override the *run()* method. 
The *run()* method is what is executed 
by the thread after you call start().
The *start()* call will return as soon 
as the thread is started. 
It will not wait until the *run()* method 
is done. The *run()* method will execute as 
if executed by a different CPU.


You can also create an anonymous 
subclass of Thread.

Runnable Interface Implementation
-
The second way to specify what code a thread
should run is by creating a class that 
implements the **java.lang.Runnable** 
interface. A Java object that implements 
the *Runnable* interface can be executed 
by a Java Thread.

The Runnable interface is a standard 
Java Interface that comes with the Java 
platform. The Runnable interface only 
has a single method *run()*.
Whatever the thread is supposed to 
do when it executes must be included 
in the implementation of the *run()* method. 
There are three ways to implement the 
Runnable interface:

- Create a Java class that implements the 
Runnable interface.
- Create an anonymous class that implements 
the Runnable interface.
- Create a Java Lambda that implements the 
Runnable interface.

**Java Class Implements Runnable**
The first way to implement the Java Runnable
interface is by creating your own Java 
class that implements the Runnable interface.

**Anonymous Implementation of Runnable**
You can also create an anonymous 
implementation of Runnable.

**Java Lambda Implementation of Runnable**
The third way to implement the Runnable 
interface is by creating a Java Lambda 
implementation of the Runnable interface. 
This is possible because the Runnable 
interface only has a single unimplemented
method, and is therefore practically 
(although possibly unintentionally) 
a functional Java interface.
