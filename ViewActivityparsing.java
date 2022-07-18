package com.example.prgm6;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
public class ViewActivity extends AppCompatActivity {
    int flag;
    TextView jsonplaceHolder, xmlplaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_view);
        flag = getIntent().getIntExtra("val", 0);
        jsonplaceHolder = findViewById(R.id.jsonplaceholder);
        xmlplaceHolder = findViewById(R.id.xmlplaceholder);
        if (flag == 1) {
            parseX();
        }
        if (flag == 2) {
            parseJ();
        }
    }
    public void parseJ() {
        String stringData;
        try {
            InputStream inputStream = getAssets().open("input.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            stringData = new String(buffer);
            Log.e("data", "parseJSON" + stringData);
            JSONObject jsonObject = new JSONObject(stringData);
            Log.e("data", "parseJSON" + jsonObject);
            Log.e("data", "parseJSON" + jsonObject.getClass().getName());
            JSONObject cityObject = jsonObject.getJSONObject("City");
            String CityName = cityObject.getString("City-name");
            String Longitude = cityObject.getString("longitude");
            String latitude = cityObject.getString("Latitude");
            String temparature = cityObject.getString("Temparature");
            String humidity = cityObject.getString("Humidity");
            Log.e("data", "parseJSON" + CityName);
            jsonplaceHolder.setText(CityName + "\n");
            jsonplaceHolder.append(Longitude + "\n");
            jsonplaceHolder.append(latitude + "\n");
            jsonplaceHolder.append(temparature + "\n");
            jsonplaceHolder.append(humidity + "\n");
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public void parseX() {
        xmlplaceHolder.setText(" ");
        try {
            InputStream inputStream=getAssets().open("input.xml");
            DocumentBuilderFactory documentBuilderFactory =
                    DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder =
                    documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(inputStream);
            NodeList cityList = document.getElementsByTagName("City");
            for (int i = 0; i < cityList.getLength(); i++) {
                Node c = cityList.item(i);
                if (c.getNodeType() == Node.ELEMENT_NODE) {
                    Element city = (Element) c;
                    // String id = city.getAttribute("id");
// Log.e("data", "parseXML:" + id);
                    NodeList cityDetailList = city.getChildNodes();
                    for (int j = 0; j < cityDetailList.getLength(); j++)
                    {
                        Node n = cityDetailList.item(j);
                        if (n.getNodeType() == Node.ELEMENT_NODE) {
                            Element cityDetail = (Element) n;
                            String value = cityDetail.getTextContent();
                            Log.e("data", "parseXML:" + value);
                            xmlplaceHolder.append(value + "\n");
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }

}