package com.riversand.solid;

/**
 * High-level modules shouldn't depend on low-level modules.
 * Both should depend on abstractions.
 */
public class DependencyInversion {

    // Tightly coupled with database
    private static void withoutDIP(){
        class MySQLDatabase {
            void connect() {}
        }

        class App {
            MySQLDatabase db = new MySQLDatabase();
        }

    }
    // Dependency injection so loosely coupled
    private static void WithDIP(){
        interface Database {
            void connect();
        }

        class MySQLDatabase implements Database {
            public void connect() {}
        }

        class App {
            Database db;
            App(Database db) {
                this.db = db;
            }
        }

    }


}


