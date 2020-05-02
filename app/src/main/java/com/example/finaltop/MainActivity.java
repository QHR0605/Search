package com.example.finaltop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Banner mbanner;
    private SearchView mSearchView;
    private MyImageLoader myImageLoader;
    private ArrayList<Integer> imagePath;
    private ArrayList<String> imageTitle;
    private TextView textView;

    private TabLayout mytab;
    private ViewPager myViewPager;
    private List<String> mtitle = new ArrayList<>();
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mytab = findViewById(R.id.MyTab);
        myViewPager = findViewById(R.id.MyViewPager);

        mtitle.add("兼职工作");
        mtitle.add("短期实习");

        mFragments.add(new CollectFragment());
        mFragments.add(new CollectFragment());

        myViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                //super.destroyItem(container, position, object);
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return mtitle.get(position);
            }
        });

        myViewPager.setOffscreenPageLimit(2);
        mytab.setupWithViewPager(myViewPager);

    }

    private void initView() {
        myImageLoader = new MyImageLoader();
        mbanner = findViewById(R.id.banner);
        mbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        mbanner.setImageLoader(myImageLoader);
        mbanner.setBannerAnimation(Transformer.ZoomOutSlide);
        mbanner.setBannerTitles(imageTitle);
        mbanner.setDelayTime(2000);
        mbanner.isAutoPlay(true);
        mbanner.setIndicatorGravity(BannerConfig.CENTER);
        mbanner.setImages(imagePath).setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
               switch (position){
                   case 0:
                       break;
                   case 1:
                       break;
                   case 2:
                       break;
                   case 3:
                       break;
                   case 4:
                       break;
               }
            }
        }).start();

    }

    private void initData() {
        imagePath = new ArrayList<>();
        imageTitle = new ArrayList<>();
        for (int i=0;i<5;i++){
            imagePath.add(R.mipmap.ic_launcher);
            imageTitle.add("ok"+i);
        }
    }

    public class MyImageLoader extends ImageLoader{

        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Glide.with(context.getApplicationContext()).load(path).into(imageView);
        }
    }

}
