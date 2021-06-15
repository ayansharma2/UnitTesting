package com.ayan.unittesting
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.ayan.unittesting.EpoxyModels.MovieListModel.*
import com.ayan.unittesting.TestUtils.withRecyclerView
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import kotlin.math.exp


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{


    @get:Rule
    val activityTestRule=ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun isRecyclerViewVisible(){
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun navigateToMovieDetails(){
       onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0,R.id.parent_layout)).perform(
           click())
        onView(withId(R.id.title)).check(matches(withText("Avengers: Endgame")))
    }


    @Test
    fun navigateToMovieCastDetails(){
        onView(withRecyclerView(R.id.recycler_view).atPositionOnView(0,R.id.parent_layout)).perform(
            click())
        onView(withId(R.id.cast_card_view)).perform(click())
        val cast=CastDetailfragment.arrayToString(OfflineMovies.movies[0].actors)
        onView(withId(R.id.cast_text_view)).check(matches(withText(cast)))
    }
}