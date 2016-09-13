package {{ cookiecutter.package_name }}.testUtils;

import android.app.Application;
import android.content.Context;
import {{ cookiecutter.package_name}}.BuildConfig;
import {{ cookiecutter.package_name}}.commons.Presenter;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import static junit.framework.Assert.assertNotNull;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public abstract class BasePresenterTest<P extends Presenter> {

  public Context context;
  public P presenter;

  @Rule
  public final RxSchedulersOverrideRule overrideSchedulersRule = new RxSchedulersOverrideRule();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    Application application = RuntimeEnvironment.application;
    assertNotNull(application);
    context = application;

    initPresenter();
  }

  @After
  public void detachView() {
    presenter.detachView();
  }

  public abstract void initPresenter();
}
