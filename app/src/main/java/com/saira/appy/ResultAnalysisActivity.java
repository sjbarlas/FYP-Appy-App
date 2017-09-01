package com.saira.appy;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.saira.appy.adapters.QuizResultAdapter;
import com.saira.appy.entities.ResultObject;
import com.saira.appy.entities.ScoreObject;

import java.util.List;

public class ResultAnalysisActivity extends AppCompatActivity {

    private static final String TAG = ResultAnalysisActivity.class.getSimpleName();

    private RecyclerView resultRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_analysis);

        resultRecyclerView = (RecyclerView)findViewById(R.id.quiz_result_analysis);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ResultAnalysisActivity.this);
        resultRecyclerView.setLayoutManager(linearLayoutManager);
        resultRecyclerView.setHasFixedSize(true);

        String mQuizResult = getIntent().getExtras().getString("RESULT");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ScoreObject storedResult = gson.fromJson(mQuizResult, ScoreObject.class);
        List<ResultObject> getStoredResults = storedResult.getQuizResultObject();
        if(getStoredResults != null){
            Log.d(TAG, " Result score " + getStoredResults.size());
        }

        QuizResultAdapter resultAdapter = new QuizResultAdapter(ResultAnalysisActivity.this, getStoredResults);
        resultRecyclerView.setAdapter(resultAdapter);
    }
}
