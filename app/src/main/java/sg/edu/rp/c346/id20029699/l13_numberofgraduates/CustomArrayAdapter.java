package sg.edu.rp.c346.id20029699.l13_numberofgraduates;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Graduates> al;

    public CustomArrayAdapter(Context context, int resource, ArrayList<Graduates> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        //TextView tv = rowView.findViewById(R.id.textViewGrad);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvCourse = rowView.findViewById(R.id.textViewCourse);
        TextView tvNumber = rowView.findViewById(R.id.textViewNumber);
        ImageView iv = rowView.findViewById(R.id.imageView);

        // Obtain the Android Version information based on the position
        Graduates current = al.get(position);

        // Set values to the TextView to display the corresponding information
        //tvYear.setText(current.getYear()+"");
        tvCourse.setText("Course: " + current.getCourse());
        tvNumber.setText("Number of Graduates: " + current.getNumOfGrad());
        tvYear.setText("Year: " + current.getYear());

        //tv.setText(current.toString());
        if (current.getNumOfGrad().equalsIgnoreCase("na")) {
            Picasso.get().load("https://forum-cdn.knime.com/uploads/default/original/3X/4/4/44174ad802a688fd685d3c407b210eeefc51ae95.jpeg").into(iv);
        }
        return rowView;
    }
}
