package com.example.abir.langtesttwo;

import android.content.Context;
import android.content.SharedPreferences;



public class SharedPref {

    private Context ctx;
    private SharedPreferences custom_preferences;


    public SharedPref(Context context) {
        this.ctx = context;
        custom_preferences = context.getSharedPreferences("MAIN_PREF", Context.MODE_PRIVATE);
    }

    private String str(int string_id) {
        return ctx.getString(string_id);
    }



    public void setCheckedLanguage(String language){
        SharedPreferences.Editor editor = custom_preferences.edit();
        editor.putString(Constant.LANGUAGE, language);
        editor.apply();
        editor.commit();
    }

    public String getCheckedLanguage(){
        return custom_preferences.getString(Constant.LANGUAGE,"en");
    }


}
