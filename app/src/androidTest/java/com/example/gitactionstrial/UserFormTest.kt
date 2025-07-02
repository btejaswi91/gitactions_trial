package com.example.gitactionstrial


import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class UserFormTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testUserInput_andSubmission_displaysGreeting() {
        // Find fields by label
        composeTestRule.onNodeWithText("Enter your name").performTextInput("John")
        composeTestRule.onNodeWithText("Enter your age").performTextInput("30")

        // Click submit button
        composeTestRule.onNodeWithText("Submit").performClick()

        // Check if greeting is shown
        composeTestRule.onNodeWithText("Hello John, you are 30 years old!").assertExists()

    }
}
