package com.gdgvitvellore.devfest17;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.yarolegovich.slidingrootnav.SlidingRootNav;
import com.yarolegovich.slidingrootnav.SlidingRootNavBuilder;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements DrawerAdapter.OnItemSelectedListener {


    private static final int POS_TRENDING = 0;
    private static final int POS_TIMELINE = 1;
    private static final int POS_FAQS = 2;
    private static final int POS_SPONSORS = 3;
    private static final int POS_SCRATCH = 4;
    private static final int POS_ABOUT = 5;



    private String[] screenTitles;
    private Drawable[] screenIcons;
    private Toolbar toolbar;

    private SlidingRootNav slidingRootNav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        slidingRootNav = new SlidingRootNavBuilder(this)
                .withToolbarMenuToggle(toolbar)
                .withMenuOpened(false)
                .withContentClickableWhenMenuOpened(false)
                .withSavedState(savedInstanceState)
                .withMenuLayout(R.layout.menu_left_drawer)
                .inject();

        screenIcons = loadScreenIcons();
        screenTitles = loadScreenTitles();

        DrawerAdapter adapter = new DrawerAdapter(Arrays.asList(
                createItemFor(POS_TRENDING).setChecked(true),
                createItemFor(POS_TIMELINE),
                createItemFor(POS_FAQS),
                createItemFor(POS_SPONSORS),
                createItemFor(POS_SCRATCH),
                createItemFor(POS_ABOUT),
                new SpaceItem(48)));
        adapter.setListener(this);

        RecyclerView list = findViewById(R.id.list);
        list.setNestedScrollingEnabled(false);
        list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(adapter);
        adapter.setSelected(POS_TIMELINE);
    }

    @Override
    public void onItemSelected(int position) {
        Fragment selectedScreen = null;
        switch (position) {
            case POS_TRENDING:
                selectedScreen = TrendingFragment.newInstance();
                break;
            case POS_TIMELINE:
                selectedScreen = TimelineFragment.newInstance();
                break;
            case POS_FAQS:
                selectedScreen = FAQFragment.newInstance();
                break;
            case POS_SPONSORS:
                selectedScreen = SponsorFragment.newInstance();
                break;
            case POS_SCRATCH:
                selectedScreen = ScratchFragment.newInstance();
                break;
            case POS_ABOUT:
                selectedScreen = AboutFragment.newInstance();
                break;
            default:
                toolbar.setTitle(screenTitles[POS_TIMELINE]);
                selectedScreen = TimelineFragment.newInstance();
                break;
        }
        toolbar.setTitle(screenTitles[position]);
        slidingRootNav.closeMenu(true);
        showFragment(selectedScreen);
    }
    private void showFragment(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    private DrawerItem createItemFor(int position) {
        return new SimpleItem(screenIcons[position], screenTitles[position])
                .withIconTint(color(R.color.primary_text))
                .withTextTint(color(R.color.primary_text))
                .withSelectedIconTint(color(R.color.accent))
                .withSelectedTextTint(color(R.color.accent));
//                .withIconTint(color(R.color.textColorSecondaryGrad))
//                .withTextTint(color(R.color.textColorPrimaryGrad))
//                .withSelectedIconTint(color(R.color.colorAccentGrad))
//                .withSelectedTextTint(color(R.color.colorAccentGrad));
    }

    private String[] loadScreenTitles() {
        return getResources().getStringArray(R.array.ld_activityScreenTitles);
    }

    private Drawable[] loadScreenIcons() {
        TypedArray ta = getResources().obtainTypedArray(R.array.ld_activityScreenIcons);
        Drawable[] icons = new Drawable[ta.length()];
        for (int i = 0; i < ta.length(); i++) {
            int id = ta.getResourceId(i, 0);
            if (id != 0) {
                icons[i] = ContextCompat.getDrawable(this, id);
            }
        }
        ta.recycle();
        return icons;
    }

    private String getEmojiByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }

    @ColorInt
    private int color(@ColorRes int res) {
        return ContextCompat.getColor(this, res);
    }
}
