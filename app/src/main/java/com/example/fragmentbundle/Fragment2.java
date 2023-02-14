package com.example.fragmentbundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class Fragment2 extends Fragment {

    private View view;
    private TextView tv_frag2;
    private Button btn_move;
    private String result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_2,container,false);

        tv_frag2 = view.findViewById(R.id.tv_frag2);
        btn_move = view.findViewById(R.id.btn_move);

        if(getArguments() != null){ //null : 빈값
            result = getArguments().getString("fromFrag1"); //프래그먼트 1로부터 setArguments된 데이터를 받아온다
            tv_frag2.setText(result);
        }

        btn_move.setOnClickListener(new View.OnClickListener() { //프래그먼트2로 이동한다
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();//무언가를 담을 꾸러미라고 생각한다
                bundle.putString("fromFrag2","ping 프래그먼트 2");
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                Fragment1 fragment1 = new Fragment1();
                fragment1.setArguments(bundle);
                transaction.replace(R.id.frame_layout,fragment1);//첫번째 인자는 교체할 화면, 두번째 인자는 이동할 곳
                transaction.commit();//저장
            }
        });

        return view;
    }
}
