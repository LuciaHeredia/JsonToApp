package com.example.jsontoapp.services;

import android.os.StrictMode;
import androidx.fragment.app.FragmentActivity;
import com.example.jsontoapp.activities.MainActivity;
import com.example.jsontoapp.objects.MonitorType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DataService {
    private final MainActivity mActivity;

    public DataService(FragmentActivity fragmentActivity) {
        mActivity = (MainActivity) fragmentActivity;
    }

    public List<MonitorType> getArrState() {
        List<MonitorType> monitorTypeList = new ArrayList<>();
        String sURL = "https://run.mocky.io/v3/381490c9-e474-437b-a56f-38b59b9c0ee1";

        mActivity.runOnUiThread((Runnable) () -> {
            URL url = null;
            String current = "";
            HttpURLConnection request;
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            try {
                url = new URL(sURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }

            try {
                assert url != null;
                request = (HttpURLConnection) url.openConnection();
                request.connect();

                InputStream is = request.getInputStream();
                InputStreamReader isr = new InputStreamReader(is);

                int data = isr.read();
                while (data != -1) {
                    current += (char) data;
                    data = isr.read();
                }

                JSONObject jsonObject = new JSONObject(current);
                JSONArray jsonArray = jsonObject.getJSONArray("MonitorType");
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    MonitorType type = new MonitorType();
                    type.setId(jsonObject1.getInt("Id"));
                    type.setName(jsonObject1.getString("Name"));
                    type.setLegendId(jsonObject1.getInt("LegendId"));
                    type.setDescription(jsonObject1.getString("description"));

                    monitorTypeList.add(type);
                }

                }catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

        });

        return monitorTypeList;
    }
}
