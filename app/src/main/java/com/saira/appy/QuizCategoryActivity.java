package com.saira.appy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.saira.appy.adapters.QuizCategoryAdapter;
import com.saira.appy.database.DatabaseQuery;
import com.saira.appy.entities.CategoryObject;

import java.util.List;

public class QuizCategoryActivity extends AppCompatActivity {

    private static final String TAG = QuizCategoryActivity.class.getSimpleName();

    private RecyclerView quizRecyclerView;

    private static int quizType = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category);

        setTitle(getString(R.string.quiz_category));

        DatabaseQuery dbQuery = new DatabaseQuery(QuizCategoryActivity.this);
        List<CategoryObject> categoryData = dbQuery.getAllQuizCategory(0);

        quizRecyclerView = (RecyclerView)findViewById(R.id.quiz_category);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        quizRecyclerView.setLayoutManager(mGrid);
        quizRecyclerView.setHasFixedSize(true);

        QuizCategoryAdapter mAdapter = new QuizCategoryAdapter(QuizCategoryActivity.this, categoryData, quizType);
        quizRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(QuizCategoryActivity.this, QuizMenuActivity.class);
        startActivity(backIntent);
    }
}
