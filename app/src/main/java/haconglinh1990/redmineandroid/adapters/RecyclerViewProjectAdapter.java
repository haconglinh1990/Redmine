package haconglinh1990.redmineandroid.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import haconglinh1990.redmineandroid.R;
import haconglinh1990.redmineandroid.activities.IssueInProjectActivity;
import haconglinh1990.redmineandroid.models.Project;
import haconglinh1990.redmineandroid.ultils.ProjectItemClickListener;
import haconglinh1990.redmineandroid.viewholder.ProjectViewHolder;

/**
 * Created by haconglinh1990 on 14/04/2016.
 */
public class RecyclerViewProjectAdapter extends RecyclerView.Adapter<ProjectViewHolder>{
    Context context;
    ArrayList<Project> projectArrayList;
    Project project;

    public RecyclerViewProjectAdapter(Context context, ArrayList<Project> projectArrayList) {
        this.context = context;
        this.projectArrayList = projectArrayList;
    }

    @Override
    public ProjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //View view = inflater.inflate(R.layout.cardview_project_list, parent, false);
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_project_list, parent, false);
        return new ProjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProjectViewHolder holder, int position) {
        project = projectArrayList.get(position);
        holder.viewIconProject.setImageResource(R.drawable.icon_finish);
        holder.viewNameProject.setText(project.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, IssueInProjectActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("projectId", project.getId());
                intent.putExtra("bundleData", bundle);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return projectArrayList.size();
    }
}
