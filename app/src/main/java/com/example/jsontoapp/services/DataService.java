package com.example.jsontoapp.services;

import android.os.StrictMode;
import androidx.fragment.app.FragmentActivity;
import com.example.jsontoapp.activities.MainActivity;
import com.example.jsontoapp.objects.Legends;
import com.example.jsontoapp.objects.Lists;
import com.example.jsontoapp.objects.Monitor;
import com.example.jsontoapp.objects.MonitorType;
import com.example.jsontoapp.objects.Tags;

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

    public Lists getListsData() {
        Lists listOfLists = new Lists();
        List<MonitorType> monitorTypeList = new ArrayList<>();
        List<Monitor> monitorList = new ArrayList<>();
        List<Legends> legendsList = new ArrayList<>();

        String sURL = "https://e11fa232-ea43-4496-8b0f-13f41eb563f4.mock.pstmn.io/config";

        mActivity.runOnUiThread(() -> {
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

                JSONObject jsonObject = new JSONObject(current); // all the JSON data

                JSONArray MonitorTypeJsonArray = jsonObject.getJSONArray("MonitorType");
                for (int i = 0; i < MonitorTypeJsonArray.length(); i++) {
                    JSONObject jsonObject1 = MonitorTypeJsonArray.getJSONObject(i);
                    MonitorType type = new MonitorType();
                    type.setId(jsonObject1.getInt("Id"));
                    type.setName(jsonObject1.getString("Name"));
                    type.setLegendId(jsonObject1.getInt("LegendId"));
                    type.setDescription(jsonObject1.getString("description"));
                    monitorTypeList.add(type);
                }

                JSONArray LegendsJsonArray = jsonObject.getJSONArray("Legends");
                for (int k = 0; k < LegendsJsonArray.length(); k++) {
                    JSONObject jsonObject2 = LegendsJsonArray.getJSONObject(k);
                    Legends legends = new Legends();
                    legends.setId(jsonObject2.getInt("Id"));

                    List<Tags> tagsList = new ArrayList<>();
                    JSONArray TagsJsonArray = jsonObject2.getJSONArray("tags");
                    for (int j = 0; j < TagsJsonArray.length(); j++) {
                        JSONObject jsonObject3 = TagsJsonArray.getJSONObject(j);
                        Tags tags = new Tags();
                        tags.setLabel(jsonObject3.getString("Label"));
                        tags.setColor(jsonObject3.getString("Color"));
                        tagsList.add(tags);
                    }
                    legends.setTags(tagsList);

                    legendsList.add(legends);
                }

                JSONArray MonitorJsonArray = jsonObject.getJSONArray("Monitor");
                for (int p = 0; p < MonitorJsonArray.length(); p++) {
                    JSONObject jsonObject4 = MonitorJsonArray.getJSONObject(p);
                    Monitor monitor = new Monitor();
                    monitor.setId(jsonObject4.getInt("Id"));
                    monitor.setName(jsonObject4.getString("Name"));
                    monitor.setDesc(jsonObject4.getString("Desc"));
                    monitor.setMonitorTypeId(jsonObject4.getInt("MonitorTypeId"));
                    monitorList.add(monitor);
                }

                isr.close(); // close url reader

                }catch (IOException | JSONException e) {
                    e.printStackTrace();
                }

        });

        listOfLists.setMonitorTypeList(monitorTypeList);
        listOfLists.setLegendsList(legendsList);
        listOfLists.setMonitorList(monitorList);
        return listOfLists;
    }
}
