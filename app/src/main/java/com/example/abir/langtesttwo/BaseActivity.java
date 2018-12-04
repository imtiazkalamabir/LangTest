package com.example.abir.langtesttwo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import java.util.Locale;

public class BaseActivity extends AppCompatActivity {

    SharedPref dataPreference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataPreference = new SharedPref(this);
        Locale locale = new Locale(dataPreference.getCheckedLanguage());
        fixupLocale(this, locale);
        new WebView(this).destroy();
        super.onCreate(savedInstanceState);

    }







    static void fixupLocale(Context ctx, Locale newLocale) {
        final Resources res = ctx.getResources();
        final Configuration config = res.getConfiguration();
        final Locale curLocale = getLocale(config);
        if (!curLocale.equals(newLocale)) {
            Locale.setDefault(newLocale);
            final Configuration conf = new Configuration(config);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                conf.setLocale(newLocale);
            }
            res.updateConfiguration(conf, res.getDisplayMetrics());
        }
    }

    private static Locale getLocale(Configuration config) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return config.getLocales().get(0);
        } else {
            //noinspection deprecation
            return config.locale;
        }
    }
}
