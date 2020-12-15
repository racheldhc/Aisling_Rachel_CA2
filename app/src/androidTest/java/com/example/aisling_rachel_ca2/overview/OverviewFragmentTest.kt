package com.example.aisling_rachel_ca2.overview
import androidx.databinding.BindingAdapter
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.aisling_rachel_ca2.MainActivity
import com.example.aisling_rachel_ca2.R
import com.example.aisling_rachel_ca2.network.ShoppingApi
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class OverviewFragmentTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    val itemNameToTest = "Spring Onions"
    val lastItemNameToTest = "Fresh Double Cream"

    /**
     * RecyclerView comes into view
     */
    @Test
    fun test_list_visible(){
        onView(withId(R.id.photos_grid)).check(matches(isDisplayed()))
    }

    /**
     * Select first list item, nav to DetailFragment
     * Check correct item is in view
     */
    @Test
    fun test_click_first_list_item_view_detail(){
        // Click item
        onView(withId(R.id.photos_grid)).perform(actionOnItemAtPosition<PhotoGridAdapter.ShoppingItemViewHolder>(0, click()))

        // Confirms title displayed matches item
        onView(withId(R.id.property_type_text)).check(matches(withText(itemNameToTest)))
    }

    /**
     * Select last list item, nav to DetailFragment
     * Check correct item is in view
     */
    @Test
    fun test_click_last_list_item_view_detail(){
        // Click item
        onView(withId(R.id.photos_grid)).perform(actionOnItemAtPosition<PhotoGridAdapter.ShoppingItemViewHolder>(33, click()))

        // Confirms title displayed matches item
        onView(withId(R.id.property_type_text)).check(matches(withText(lastItemNameToTest)))
    }

    /**
     * Select list item, nav to DetailFragment
     * Check back button moves back to Recyclerview
     */
    @Test
    fun test_back_navigation(){
        // Click item
        onView(withId(R.id.photos_grid)).perform(actionOnItemAtPosition<PhotoGridAdapter.ShoppingItemViewHolder>(0, click()))

        // Confirms title displayed matches item
        onView(withId(R.id.property_type_text)).check(matches(withText(itemNameToTest)))

        // Back navigation
        pressBack()

        //Confirm user is back at Overview Fragment
        onView(withId(R.id.photos_grid)).check(matches(isDisplayed()))



    }


}