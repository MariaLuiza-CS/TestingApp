package com.example.testingapp

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testingapp.ui.theme.TestingAppTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityKtTest {

    @get: Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setContent {
            TestingAppTheme {
                ButtonAdd(Color.Magenta)
            }
        }
    }

    @Test
    fun verifyIfAllViewsExists() {
        composeTestRule
            .onNodeWithTag(
                "ButtonAdd"
            ).assertExists()
        composeTestRule.onNodeWithTag("TextAdd", useUnmergedTree = true).assertExists()
        composeTestRule.onNodeWithTag("AddIcon", useUnmergedTree = true).assertExists()
    }

    @Test
    fun verifyIfAllViewsIsDisplayed() {
        composeTestRule.onNodeWithTag("ButtonAdd").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithTag("TextAdd", useUnmergedTree = true).assertIsDisplayed()
        composeTestRule.onNodeWithTag("AddIcon", useUnmergedTree = true).assertIsDisplayed()
    }

    @Test
    fun verifyIfSomeComponentHaveMatchContentDescription() {
        composeTestRule.onAllNodesWithContentDescription("Add Icon", useUnmergedTree = true)
            .assertCountEquals(1)
        composeTestRule.onAllNodesWithContentDescription("Add Icon", useUnmergedTree = true)
            .assertAny(hasTestTag("AddIcon"))
        composeTestRule.onAllNodesWithContentDescription("Add Icon", useUnmergedTree = true)
            .assertAll(hasClickAction())
    }

    @Test
    fun verifyIfHasClickAction() {
        composeTestRule
            .onNodeWithTag(
                "ButtonAdd"
            ).performClick()
    }

    @Test
    fun verifyIfHasChildrenDisplayed() {
        composeTestRule.onNode(
            hasParent(
                hasTestTag(
                    "ButtonAdd"
                )
            )
        ).assertIsDisplayed()
    }
}