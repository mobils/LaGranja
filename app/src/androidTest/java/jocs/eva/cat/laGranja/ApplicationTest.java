package jocs.eva.cat.laGranja;

import static org.junit.Assert.assertEquals;

import android.app.Application;
import android.content.Context;

import androidx.test.InstrumentationRegistry;
import androidx.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest  {
    public ApplicationTest() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("jocs.eva.cat.laGranja", appContext.getPackageName());
    }

}


