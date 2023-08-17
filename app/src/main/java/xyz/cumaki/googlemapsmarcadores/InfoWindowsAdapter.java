package xyz.cumaki.googlemapsmarcadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InfoWindowsAdapter extends AppCompatActivity implements GoogleMap.InfoWindowAdapter {


    private static final String API_KEY = "AIzaSyC39iWbZDWCGeLftIRdIU8c96KdSnK0Org";
    private Context context;
    //private LayoutInflater inflater;

    /* public InfoWindowsAdapter(LayoutInflater inflater){
         this.inflater = inflater;
     }*/
    public InfoWindowsAdapter(Context context) {
        this.context = context;
    }


    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }

    @Override
    public View getInfoContents(Marker marker) {
        View infoView = LayoutInflater.from(context).inflate(R.layout.custom_info_window, null);



        // Personaliza la vista con la información del marcador
        TextView titleTextView = infoView.findViewById(R.id.titleTextView);
        TextView snippetTextView = infoView.findViewById(R.id.snippetTextView);
        ImageView Imagen=infoView.findViewById(R.id.imageView2);

/*        RequestQueue queue = Volley.newRequestQueue(this);
String photoReference = (String) marker.getTag();
        String photoUrl = "https://maps.googleapis.com/maps/api/place/photo?" +
                "maxwidth=400" +
                "&photo_reference=" + photoReference +
                "&key=" +API_KEY;

        ImageRequest imageRequest = new ImageRequest(photoUrl,
                new Response.Listener<android.graphics.Bitmap>() {
                    @Override
                    public void onResponse(android.graphics.Bitmap response) {
                        Imagen.setImageBitmap(response);
                    }
                }, 0, 0, ImageView.ScaleType.CENTER_CROP, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });

        queue.add(imageRequest);*/

        Bitmap foto = (Bitmap) marker.getTag();
        titleTextView.setText(marker.getTitle());
        snippetTextView.setText(marker.getSnippet());
        Imagen.setImageBitmap(foto);;


        return infoView;

        }
    }


