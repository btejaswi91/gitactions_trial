package com.example.gitactionstrial


import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class UserFormViewModelTest {

    private lateinit var viewModel: UserFormViewModel

    @Before
    fun setUp() {
        viewModel = UserFormViewModel()
    }

    @Test
    fun testInitialState() {
        val state = viewModel.userData.value
        assertEquals("", state.name)
        assertEquals("", state.age)
        assertFalse(state.submitted)
    }

    @Test
    fun testUpdateNameAndAge() {
        viewModel.updateName("Alice")
        viewModel.updateAge("28")
        val state = viewModel.userData.value
        assertEquals("Alice", state.name)
        assertEquals("28", state.age)
    }

    @Test
    fun testSubmission() {
        viewModel.updateName("Bob")
        viewModel.updateAge("32")
        viewModel.submit()
        val state = viewModel.userData.value
        assertTrue(state.submitted)
        assertEquals("Bob", state.name)
        assertEquals("32", state.age)
    }

    @Test
    fun testReset() {
        viewModel.updateName("Charlie")
        viewModel.updateAge("22")
        viewModel.submit()
        viewModel.reset()
        val state = viewModel.userData.value
        assertEquals(UserData(), state)
    }
}
