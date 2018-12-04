package com.example.abir.langtesttwo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;



public class Tools {

    private static String URL_IMG_HEADER = "https://maps.googleapis.com/maps/api/place/photo?";
    private static String checkedLang;


    public static void langChangeAction(final Activity ctx) {
        try {

            final SharedPref dataPreference = new SharedPref(ctx);


            LayoutInflater inflater = LayoutInflater.from(ctx);
            View dialogLayout = inflater.inflate(R.layout.dialog_lang_change, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setView(dialogLayout);

            final TextView tvDialogTitle = dialogLayout.findViewById(R.id.dialog_title);

            final TextView tvEnglish = dialogLayout.findViewById(R.id.tvEnglish);
            final TextView tvRussian = dialogLayout.findViewById(R.id.tvRussian);
            final TextView tvSpanish = dialogLayout.findViewById(R.id.tvSpanish);
            final TextView tvPortuguese = dialogLayout.findViewById(R.id.tvPortuguese);
            final TextView tvItalian = dialogLayout.findViewById(R.id.tvItalian);
            final TextView tvFrench = dialogLayout.findViewById(R.id.tvFrench);
            final TextView tvGerman = dialogLayout.findViewById(R.id.tvGerman);
            final TextView tvDutch = dialogLayout.findViewById(R.id.tvDutch);
            final TextView tvMalay = dialogLayout.findViewById(R.id.tvMalay);
            final TextView tvArabic = dialogLayout.findViewById(R.id.tvArabic);


            final CheckBox checkBoxEnglish = dialogLayout.findViewById(R.id.checkbox_english);
            final CheckBox checkBoxRussian = dialogLayout.findViewById(R.id.checkbox_russia);
            final CheckBox checkBoxDutch = dialogLayout.findViewById(R.id.checkbox_dutch);
            final CheckBox checkBoxSpanish = dialogLayout.findViewById(R.id.checkbox_spanish);
            final CheckBox checkBoxPortuguese = dialogLayout.findViewById(R.id.checkbox_portuguese);
            final CheckBox checkBoxItalian = dialogLayout.findViewById(R.id.checkbox_italian);
            final CheckBox checkBoxFrench = dialogLayout.findViewById(R.id.checkbox_french);
            final CheckBox checkBoxMalaysian = dialogLayout.findViewById(R.id.checkbox_malaysian);
            final CheckBox checkBoxGerman = dialogLayout.findViewById(R.id.checkbox_german);
            final CheckBox checkBoxArabic = dialogLayout.findViewById(R.id.checkbox_arabic);

            Button btnApply = dialogLayout.findViewById(R.id.btn_apply);

            btnApply.setText(ctx.getResources().getString(R.string.apply));
            tvDialogTitle.setText(ctx.getResources().getString(R.string.choose_a_language));

            final String language = dataPreference.getCheckedLanguage();


            setLocal(language, ctx, dataPreference);
            getCheckedLanguage(language,checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);


            final AlertDialog customAlertDialog = builder.create();


            customAlertDialog.show();

            btnApply.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if(!language.equals(checkedLang)){

                        setLocal(checkedLang,ctx,dataPreference);

                        Toast.makeText(ctx,  "Language changed succssfully", Toast.LENGTH_SHORT).show();

                        Intent i = ctx.getBaseContext().getPackageManager()
                                .getLaunchIntentForPackage( ctx.getBaseContext().getPackageName() );
                        assert i != null;
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        ctx.startActivity(i);
                    }



                    customAlertDialog.dismiss();

                }
            });


            tvEnglish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxEnglish.setChecked(true);

                    checkedLang = Constant.ENG_LANG;

                }
            });

            tvRussian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxRussian.setChecked(true);

                    checkedLang = Constant.RUS_LANG;
                }
            });

            tvSpanish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxSpanish.setChecked(true);

                    checkedLang = Constant.SPA_LANG;

                }
            });

            tvPortuguese.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxPortuguese.setChecked(true);

                    checkedLang = Constant.POR_LANG;

                }
            });

            tvGerman.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxGerman.setChecked(true);

                    checkedLang = Constant.GER_LANG;

                }
            });

            tvDutch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxDutch.setChecked(true);

                    checkedLang = Constant.DUT_LANG;

                }
            });

            tvItalian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxItalian.setChecked(true);

                    checkedLang = Constant.ITA_LANG;

                }
            });

            tvFrench.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxFrench.setChecked(true);

                    checkedLang = Constant.FRE_LANGE;

                }
            });

            tvMalay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxMalaysian.setChecked(true);

                    checkedLang = Constant.MAL_LANG;


                }
            });

            tvArabic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxArabic.setChecked(true);

                    checkedLang = Constant.ARA_LANG;

                }
            });





            checkBoxArabic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxArabic.setChecked(true);

                    checkedLang = Constant.ARA_LANG;

                }
            });
            checkBoxEnglish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxEnglish.setChecked(true);

                    checkedLang = Constant.ENG_LANG;

                }
            });
            checkBoxRussian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxRussian.setChecked(true);

                    checkedLang = Constant.RUS_LANG;


                }
            });
            checkBoxSpanish.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxSpanish.setChecked(true);

                    checkedLang = Constant.SPA_LANG;


                }
            });
            checkBoxPortuguese.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxPortuguese.setChecked(true);

                    checkedLang = Constant.POR_LANG;


                }
            });
            checkBoxItalian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxItalian.setChecked(true);

                    checkedLang = Constant.ITA_LANG;


                }
            });
            checkBoxFrench.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxFrench.setChecked(true);

                    checkedLang = Constant.FRE_LANGE;

                }
            });
            checkBoxDutch.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxDutch.setChecked(true);

                    checkedLang = Constant.DUT_LANG;


                }
            });
            checkBoxGerman.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxGerman.setChecked(true);

                    checkedLang = Constant.GER_LANG;


                }
            });
            checkBoxMalaysian.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    invalidateCheckBox(checkBoxArabic, checkBoxEnglish, checkBoxRussian, checkBoxItalian, checkBoxFrench, checkBoxSpanish, checkBoxPortuguese, checkBoxDutch, checkBoxGerman, checkBoxMalaysian);

                    checkBoxMalaysian.setChecked(true);

                    checkedLang = Constant.MAL_LANG;


                }
            });







        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void invalidateCheckBox(CheckBox checkBoxArabic, CheckBox checkBoxEnglish, CheckBox checkBoxRussian, CheckBox checkBoxItalian, CheckBox checkBoxFrench, CheckBox checkBoxSpanish, CheckBox checkBoxPortuguese, CheckBox checkBoxDutch, CheckBox checkBoxGerman, CheckBox checkBoxMalaysian) {
        checkBoxArabic.setChecked(false);
        checkBoxEnglish.setChecked(false);
        checkBoxRussian.setChecked(false);
        checkBoxItalian.setChecked(false);
        checkBoxFrench.setChecked(false);
        checkBoxSpanish.setChecked(false);
        checkBoxPortuguese.setChecked(false);
        checkBoxDutch.setChecked(false);
        checkBoxGerman.setChecked(false);
        checkBoxMalaysian.setChecked(false);
    }

    public static void setLocal(String lang, Context ctx, SharedPref dataPreference){

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        final Configuration config = ctx.getApplicationContext().getResources().getConfiguration();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            config.setLocale(locale);
        }else {config.locale = locale;
        }
        ctx.getApplicationContext().getResources().updateConfiguration(config, ctx.getApplicationContext().getResources().getDisplayMetrics());

        dataPreference.setCheckedLanguage(lang);
        new WebView(ctx.getApplicationContext()).destroy();

    }

    private static void getCheckedLanguage(String lang, CheckBox checkBoxArabic, CheckBox checkBoxEnglish, CheckBox checkBoxRussian, CheckBox checkBoxItalian, CheckBox checkBoxFrench, CheckBox checkBoxSpanish, CheckBox checkBoxPortuguese, CheckBox checkBoxDutch, CheckBox checkBoxGerman, CheckBox checkBoxMalaysian) {

        checkedLang = lang;

        if(lang.equals(Constant.ENG_LANG)){
            checkBoxEnglish.setChecked(true);
//            Toast.makeText(this, getString(R.string.English), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.RUS_LANG)){
            checkBoxRussian.setChecked(true);

//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.ITA_LANG)){
            checkBoxItalian.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.FRE_LANGE)){
            checkBoxFrench.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.GER_LANG)){
            checkBoxGerman.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.SPA_LANG)){
            checkBoxSpanish.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.POR_LANG)){
            checkBoxPortuguese.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.MAL_LANG)){
            checkBoxMalaysian.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.ARA_LANG)){
            checkBoxArabic.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else if(lang.equals(Constant.DUT_LANG)){
            checkBoxDutch.setChecked(true);
//            Toast.makeText(this, getString(R.string.setting_language_bangla), Toast.LENGTH_SHORT).show();

        }else {
//            Toast.makeText(this, getString(R.string.No_Language_is_Selected), Toast.LENGTH_SHORT).show();
        }
    }

}
