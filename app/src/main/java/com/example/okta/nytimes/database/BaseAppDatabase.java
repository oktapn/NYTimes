package com.example.okta.nytimes.database;

import android.app.Application;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmSchema;

public class BaseAppDatabase extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //kode konfigurasi Realm
        RealmConfiguration config = new RealmConfiguration.Builder()
                //versi database
                .schemaVersion(1)
                .migration(new DataMigration())
                .build();
        Realm.setDefaultConfiguration(config);
        Realm.getInstance(config);

    }

    @Override
    public void onTerminate() {
        Realm.getDefaultInstance().close();
        super.onTerminate();
    }

    private class DataMigration implements RealmMigration {
        @Override
        public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {

            //Mengambil schema
            RealmSchema schema = realm.getSchema();

            //membuat schema baru jika versi 0
            if (oldVersion == 0) {
                schema.create("Article")
                        .addField("article_id", int.class)
                        .addField("imgurl", String.class)
                        .addField("snippet", String.class)
                        .addField("tgl", String.class)
                        .addField("headline", String.class);
                schema.create("Keyword")
                        .addField("id", int.class)
                        .addField("keyword", String.class);
                oldVersion++;
            }
        }
    }
}
