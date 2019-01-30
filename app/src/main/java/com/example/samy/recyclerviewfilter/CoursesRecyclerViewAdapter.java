package com.example.samy.recyclerviewfilter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CoursesRecyclerViewAdapter extends RecyclerView.Adapter<CoursesRecyclerViewAdapter.CourseView> {
    List<String> list;
    Context context;
    public CoursesRecyclerViewAdapter(List<String> list){
        this.list=list;
    }
    @NonNull
    @Override
    public CourseView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_layout,viewGroup,false);
         CourseView courseView=new CourseView(view);
        return courseView;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseView courseView, int i) {
          courseView.textView.setText(list.get(i));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class CourseView extends RecyclerView.ViewHolder {
        TextView textView;
        public CourseView(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textView_course);
        }
    }

    public void onUpdate(List<String> oldList){
        list=new ArrayList<>();
        list.addAll(oldList);
        notifyDataSetChanged();
    }
}
