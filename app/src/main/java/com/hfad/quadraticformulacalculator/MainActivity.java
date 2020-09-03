package com.hfad.quadraticformulacalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText a;
    EditText b;
    EditText c;
    TextView answerOne;
    TextView answerTwo;
    private static DecimalFormat df = new DecimalFormat("0.000");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickUpdate(View v)
        {
            MathLogic logic = new MathLogic();
            a = findViewById(R.id.editText2);
            b = findViewById(R.id.editText3);
            c = findViewById(R.id.editText);
            answerOne = findViewById(R.id.textView2);
            answerTwo = findViewById(R.id.textView);
            String aString = a.getText().toString();
            String bString = b.getText().toString();
            String cString = c.getText().toString();
            if(logic.isNull(aString) || logic.isNull(bString) || logic.isNull(cString))
            {
                CharSequence invalid = "Please enter valid numbers";
                int duration = Toast.LENGTH_SHORT;
                Toast invalidToast = Toast.makeText(this,invalid,duration);
                invalidToast.show();
                return;
            }
            double variableA = Double.parseDouble(aString);
            double variableB = Double.parseDouble(bString);
            double variableC = Double.parseDouble(cString);
            double[] answers = logic.getX(variableA, variableB, variableC);
            answerOne.setText(df.format(answers[0]));
            answerTwo.setText(df.format(answers[1]));
            GraphView graph = (GraphView) findViewById(R.id.imageView3);
            graph.removeAllSeries();
            LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>();
            int numberOfDataPoints = 200;
            double x,y;
            x = -10.1;
           /* if(answers[0] < answers[1])
            {
                x = answers[0];
            }
            else
            {
                x = answers[1];
            } */
            for(int i = 0; i< numberOfDataPoints; i++)
            {
                x += .1;
                y = (variableA * x * x) + variableB * x + variableC;
                series.appendData(new DataPoint(x,y), true, numberOfDataPoints);
            }
            graph.addSeries(series);

        }
}
