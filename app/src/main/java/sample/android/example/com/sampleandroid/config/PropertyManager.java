package sample.android.example.com.sampleandroid.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


/**
 * Created by sanghwan on 2017. 3. 17..
 */


public class PropertyManager {
    private static PropertyManager instance;
    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    SharedPreferences mPrefs;
    SharedPreferences.Editor mEditor;

    private PropertyManager() {
        Context context = WenwoApplication.getContext();
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mEditor = mPrefs.edit();
    }

    public String getToken(){
        return mPrefs.getString("token",null);
    }
    public void setToken(String token){
        mEditor.putString("token", token);
        mEditor.commit();
    }

/*
    public boolean isFirst() {
        return mPrefs.getBoolean("First",true);
    }
    public void setFirst(Boolean bool) {
        mEditor.putBoolean("First", bool);
        mEditor.commit();
    }

    public int getStartTime(){
        return mPrefs.getInt("StartTime",8);
    }
    public void setStartTimeType(int time){
        mEditor.putInt("StartTime", time);
        mEditor.commit();
    }

    public String getToken(){
        return mPrefs.getString("token",null);
    }
    public void setToken(String token){
        mEditor.putString("token", token);
        mEditor.commit();
    }

    public List<CodeDTO> getTocDTOs() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        List<CodeDTO> alCodeDTOs =  objectMapper.readValue(prefs.getString("TocDTOs", "[]"), objectMapper.getTypeFactory().constructCollectionType(List.class, CodeDTO.class));
        return alCodeDTOs;
    }
    public void setTocDTOs(List<CodeDTO> KeyWords) throws Exception{
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(KeyWords);
        mEditor.putString("TocDTOs", json);
        mEditor.commit();
    }*/




}
