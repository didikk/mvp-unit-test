package me.didik.newmvp.feature.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import me.didik.newmvp.app.Messages;
import me.didik.newmvp.base.ObjectCallback;
import me.didik.newmvp.data.UserRepository;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by didik on 12/18/16.
 * Test
 */
public class LoginPresenterTest {
    @Mock
    private LoginView mockView;

    @Mock
    private UserRepository mockUserRepository;

    @Captor
    private ArgumentCaptor<ObjectCallback<String>> argumentCaptor;

    private LoginPresenter presenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        presenter = new LoginPresenter(mockUserRepository);
        presenter.attachView(mockView);

        when(mockView.getUserName()).thenReturn("frieska");
        when(mockView.getPassword()).thenReturn("laksani");
    }

    @Test
    public void shouldShowFieldEmptyMessage() {
        when(mockView.getUserName()).thenReturn("");
        when(mockView.getPassword()).thenReturn("laksani");

        presenter.doLogin();
        verify(mockView).showMessage(Messages.USERNAME_EMPTY);
    }

    @Test
    public void shouldShowInvalidMessage() {
        presenter.doLogin();
        verify(mockView, times(1)).showLoading();

        verify(mockUserRepository).doLogin(anyString(), anyString(),
                argumentCaptor.capture());

        argumentCaptor.getValue().onFailure(Messages.USERNAME_IS_INVALID);

        verify(mockView, times(1)).hideLoading();
        verify(mockView).showMessage(Messages.USERNAME_IS_INVALID);
    }

    @Test
    public void shouldLoginSuccess() {
        presenter.doLogin();
        verify(mockView, times(1)).showLoading();

        verify(mockUserRepository).doLogin(anyString(), anyString(),
                argumentCaptor.capture());

        argumentCaptor.getValue().onSuccess(Messages.LOGIN_SUCCESS);

        verify(mockView, times(1)).hideLoading();
        verify(mockView).showMessage(Messages.LOGIN_SUCCESS);
    }

}