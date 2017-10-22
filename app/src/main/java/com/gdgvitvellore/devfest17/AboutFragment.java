package com.gdgvitvellore.devfest17;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.vansuita.materialabout.builder.AboutBuilder;
import com.vansuita.materialabout.views.AboutView;

public class AboutFragment extends Fragment {

    private View rootView;

    public AboutFragment() {
    }

    public static AboutFragment newInstance() {
        return new AboutFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_about, container, false);

        // Find the relative layout to which programatically generated view is to be added
        RelativeLayout aboutRelativeLayout = rootView.findViewById(R.id.aboutRelativeLayout);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);

        AboutView view = AboutBuilder.with(rootView.getContext())
                .setPhoto(R.mipmap.profile_picture)
                .setCover(R.mipmap.profile_cover)
                .setName(getString(R.string.about_name))
                .setSubTitle(getString(R.string.about_subtitle))
                .setBrief(getString(R.string.about_brief))
                .setAppIcon(R.mipmap.ic_launcher)
                .setAppName(R.string.app_name)
                .addGooglePlayStoreLink("9033840087167154769")
                .addGitHubLink("GDGVIT")
                .addFacebookLink("gdgvitvellore")
                .addEmailLink("gdgvitvellore@gmail.com")
                .addWebsiteLink("https://gdgvitvellore.com")
                .addTwitterLink("gdgvit")
                .addGooglePlusLink("+gdgvitvellore")
                .addMoreFromMeAction("GDG VIT Vellore")
                .addInstagramLink("gdgvitvellore")
                .addFiveStarsAction()
                .setVersionNameAsAppSubTitle()
                .addShareAction(R.string.app_name)
                .setWrapScrollView(true)
                .setLinksAnimated(true)
                .setShowAsCard(true)
                .setDividerColor(R.color.accent)
                .setNameColor(R.color.textColorPrimaryGrad)
                .setPhoto(R.drawable.cirularlogo)
                .setCover(R.drawable.rectangularshit)
                .build();

        aboutRelativeLayout.addView(view, params);


        return rootView;
    }

}
