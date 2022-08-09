package com.example.hospitals;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * @author vignatiy
 */
public class usingUrl {
    public String readURL (String myUrl) throws IOException {
        String stringOfData = "";
        InputStream input = null;
        HttpURLConnection connectionUrl = null;
        try{
            URL url = new URL(myUrl);
            connectionUrl = (HttpURLConnection)url.openConnection();
            connectionUrl.connect();
            input = connectionUrl.getInputStream();
            BufferedReader bufferedReader =new BufferedReader(new InputStreamReader(input));
            StringBuffer stringBuffer = new StringBuffer();
            String stringline = "";
            while ((stringline = bufferedReader.readLine())!= null){
                stringBuffer.append(stringline);
            }
            stringOfData = stringBuffer.toString();
            bufferedReader.close();
        } catch (MalformedURLException excp) {
            excp.printStackTrace();
        } catch (IOException excp) {
            excp.printStackTrace();
        }
       finally {
            if(input != null) {
                input.close();
            }
            connectionUrl.disconnect();
        }
        Log.d("usingUrl","return the data: "+stringOfData);
        return stringOfData;
    }
}
