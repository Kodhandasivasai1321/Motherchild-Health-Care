package com.example.lenovo.myhealth;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * A simple {@link Fragment} subclass.
 */
public class YoutubeFragment extends Fragment {
    WebView webView=null;


    public YoutubeFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        //String gurl = this.getArguments().getString("url");
        View v= inflater.inflate(R.layout.fragment_youtube, container, false);
        webView=v.findViewById(R.id.myweb);
        WebSettings webSettings=webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.loadUrl("https://www.youtube.com/results?search_query=health+care+in+pregnancy+time");
        return v;

    }

}
