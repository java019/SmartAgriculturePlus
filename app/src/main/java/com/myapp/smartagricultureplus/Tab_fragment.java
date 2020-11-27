package com.myapp.smartagricultureplus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Tab_fragment extends Fragment {


    //静态
    private  static final String BUNDLE_KEY_TITLE="key_title";
    private TextView mtitle;
    private String mtext;

    //回调
    public static interface onTitleOnClickListener {
        void  OnClick1(String title);
    }

    private onTitleOnClickListener onClickListener;

    public void setonTitleOnClickListener(onTitleOnClickListener listener )
    {
        this.onClickListener = listener;
    }

    public static com.myapp.smartagricultureplus.Tab_fragment newInstance(String mtext)
    {
        Bundle bundle =new Bundle();
        bundle.putString(BUNDLE_KEY_TITLE,mtext);
        com.myapp.smartagricultureplus.Tab_fragment tab_fragment = new com.myapp.smartagricultureplus.Tab_fragment();
        //
        tab_fragment.setArguments(bundle);
        return tab_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       Bundle bundle = getArguments();

       if (bundle != null)
       {
           mtext = bundle.getString(BUNDLE_KEY_TITLE,"");
       }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mtitle = view.findViewById(R.id.te_title);
        mtitle.setText(mtext);

        mtitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //写法1 容易报错
//                MainActivity mainActivity = (MainActivity) getActivity();
//                mainActivity.changWechatTab("微信 123");

                //写法2 fragment不知道是该事件
//                Activity activity = getActivity();
//                if (activity instanceof  MainActivity)
//                {
//                    ((MainActivity) activity).changWechatTab("微信");
//                }

                // 暴露方法 让Activity知道 你想不想知道我就不知道
                if (onClickListener !=null)
                {
                    onClickListener.OnClick1("12");
                }


            }
        });
    }
    public void changTitle(String title)
    {
        //避免空指针 强行调用方法
       if (!isAdded())
       {
           return;
       }
       mtitle.setText(title);
    }
}
