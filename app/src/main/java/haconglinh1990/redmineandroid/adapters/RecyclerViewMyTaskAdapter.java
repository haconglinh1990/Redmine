package haconglinh1990.redmineandroid.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.amulyakhare.textdrawable.TextDrawable;
import com.amulyakhare.textdrawable.util.ColorGenerator;

import java.util.ArrayList;

import haconglinh1990.redmineandroid.R;
import haconglinh1990.redmineandroid.models.Issue;
import haconglinh1990.redmineandroid.network.api.APIClient;
import haconglinh1990.redmineandroid.viewholder.MyTaskViewHolder;


/**
 * Created by haconglinh1990 on 22/04/2016.
 */
public class RecyclerViewMyTaskAdapter extends RecyclerView.Adapter<MyTaskViewHolder>{
    Context context;
    ArrayList<Issue> issuesList;
    Issue issues;

    public RecyclerViewMyTaskAdapter(Context context, ArrayList<Issue> issuesList) {
        this.context = context;
        this.issuesList = issuesList;
    }

    @Override
    public MyTaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview_issue_list, parent, false);
        return new MyTaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyTaskViewHolder holder, int position) {
        int color, textColor;
        issues = issuesList.get(position);

        holder.viewNameIssue.setText(issues.getSubject());
        //Log.v(APIClient.MY_TAG, "Version: " + issues.getFixedVersion().getName());
        holder.viewIdIssue.setText("#" + issues.getId());
        holder.viewStatus.setText("  " + issues.getStatus().getName());

        switch (issues.getPriority().getName()) {
            case "Low":
                textColor = Color.rgb(191, 255, 0);
                break;

            case "Normal":
                textColor = Color.rgb(64, 255, 0);
                break;
            case "High":
                textColor = Color.rgb(255, 128, 0);
                break;
            case "Urgent":
                textColor = Color.rgb(255, 0, 0);
                break;
            case "Immediate":
                textColor = Color.rgb(0, 0, 0);
                break;

            default:
                textColor = Color.rgb(255, 230, 230);
                break;
        }

        holder.viewPriority.setTextColor(textColor);
        holder.viewNameUser.setText(" " + issues.getAuthor().getName());
        holder.viewPriority.setText("  " + issues.getPriority().getName());
        holder.viewDueDate.setText(" " + issues.getDueDate());
        holder.viewNameProject.setText(issues.getProject().getName());
        holder.viewVersionProject.setText("  v0.1");
        holder.viewNumberPercent.setText(issues.getDoneRatio() + "%");

        TextDrawable iconUserDrawable = TextDrawable.builder()
                .beginConfig()
                .fontSize(16) /* size in px */
                .bold()
                .endConfig()
                .buildRound(issues.getAuthor().getName().substring(0, 1), ColorGenerator.MATERIAL.getRandomColor());
        holder.viewIconUser.setImageDrawable(iconUserDrawable);

        switch (issues.getTracker().getName()) {
            case "Feature":
                color = Color.rgb(0, 0, 255);
                break;
            case "Develop":
                color = Color.rgb(0, 191, 255);
                break;
            case "Design":
                color = Color.rgb(0, 255, 255);
                break;
            case "Support":
                color = Color.rgb(0, 255, 128);
                break;
            case "Test":
                color = Color.rgb(64, 255, 0);
                break;
            case "Bug":
                color = Color.rgb(255, 64, 0);
                break;
            case "Research":
                color = Color.rgb(255, 255, 0);
                break;

            default:
                color = Color.rgb(255, 230, 230);
                break;
        }


        TextDrawable iconTrackerDrawable = TextDrawable.builder()
                .beginConfig()
                .textColor(Color.BLACK)
                .fontSize(20) /* size in px */
                .bold()
                .endConfig()
                .buildRoundRect(issues.getTracker().getName(), color, 4);

        holder.viewIconTracker.setImageDrawable(iconTrackerDrawable);
        holder.viewIconClock.setImageResource(R.drawable.icon_clock);

        holder.progressBarIssue.setProgress(issues.getDoneRatio());
    }

    @Override
    public int getItemCount() {
        return issuesList.size();
    }
}
