package com.example.homework3java3.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.homework3java3.R;

public class FirstFragment extends Fragment {
    private Button button;
    private EditText editText;
    private String text;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.et_editText);
        button = view.findViewById(R.id.btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")){
                    editText.setError("Заполните поле");
                }else {
                    Fragment fragment = new SecondFragment();
                    Bundle bundle = new Bundle();
                    text = editText.getText().toString();
                    bundle.putString("first", text);
                    fragment.setArguments(bundle);
                    getActivity().getSupportFragmentManager().beginTransaction().addToBackStack(null).
                            replace(R.id.container_fragment,fragment).commit();
                }
            }
        });

    }
}