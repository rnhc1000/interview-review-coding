package br.dev.ferreiras.challenges;

public class Singleton {

    private Singleton() {}

    private static class SingletonHelper {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {

        return SingletonHelper.INSTANCE;
    }
}
/*

Implementation	        Thread-Safe	    Lazy Initialization	    Performance	    Additional Features
Basic Singleton         	❌ No	            ✅ Yes	         🚀 Fast	    ❌Not safe for multithreading
Synchronized Method	        ✅ Yes	            ✅ Yes	        🐢 Slow	Safe but impacts performance
Double-Checked Locking	    ✅ Yes	            ✅ Yes	        🚀 Fast	Best for high-performance apps
Inner Static Class (Bill Pugh)	✅ Yes	        ✅ Yes	        🚀  Fast	        Most recommended approach
Enum Singleton	            ✅ Yes	            ✅ Yes	        🚀  Fast	    Best for serialization

📌 Summary: Where to Use Singleton?
Use Case	                Why Use Singleton?	                Benefits
Database Connection	        Prevent multiple connections	    Reduces resource usage
Logger Service	            Ensure consistent logging	        Avoids redundant file I/O
Configuration Manager	    Load properties only once	        Centralized access to settings
Thread Pool Manager	        Manage thread execution	            Efficient multithreading
Spring Beans	            Manage services and repositories	Automatic singleton management                                                                             & reflection safety
 */