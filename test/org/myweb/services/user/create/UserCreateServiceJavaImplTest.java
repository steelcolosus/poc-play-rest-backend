package org.myweb.services.user.create;

import models.user.User;
import models.user.UserPasswordSettings;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.myweb.db.Dao;
import org.myweb.services.JavaServiceResult;
import org.myweb.services.ServiceException;
import org.myweb.services.user.check.UserCheckEmailServiceJava;
import org.myweb.services.user.check.UserCheckEmailServiceJavaImpl;
import org.myweb.services.user.check.UserCheckLoginServiceJava;
import org.myweb.services.user.check.UserCheckLoginServiceJavaImpl;
import org.myweb.utils.test.TestHelper;
import org.myweb.utils.security.PasswordGenerationService;
import play.mvc.Http;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserCreateServiceJavaImplTest {

    private Dao mockedDao = mock(Dao.class);
    private UserCheckLoginServiceJava checkLogin = mock(UserCheckLoginServiceJava.class);
    private UserCheckEmailServiceJava checkEmail = mock(UserCheckEmailServiceJava.class);
    private PasswordGenerationService passwordGenerationService = mock(PasswordGenerationService.class);

    private UserCreateServiceJavaImpl service;

    @Before
    public void setUp() throws Exception {
        when(checkLogin.check("loginExist"))
                .thenThrow(
                        new ServiceException(
                                UserCheckLoginServiceJavaImpl.class.getName(), Http.Status.BAD_REQUEST,
                                "error msg", "user msg"
                        )
                );
        when(checkLogin.check("totoLogin"))
                .thenReturn(JavaServiceResult.buildServiceResult(Http.Status.OK));

        when(checkEmail.check("emailexist@toto.fr"))
                .thenThrow(
                        new ServiceException(
                                UserCheckEmailServiceJavaImpl.class.getName(), Http.Status.BAD_REQUEST,
                                "error msg","user msg"
                        )
                );
        when(checkEmail.check("toto@toto.fr"))
                .thenReturn(JavaServiceResult.buildServiceResult(Http.Status.OK));

        UserPasswordSettings userPasswordSettings = TestHelper
                .userPasswordSettingsFactory(new byte[0], 1, 1, "algo", new byte[0], 1);
        when(passwordGenerationService.generate(userPasswordSettings, "password".toCharArray()))
                .thenReturn(userPasswordSettings);

        service = new UserCreateServiceJavaImpl(
                mockedDao, checkLogin, checkEmail, passwordGenerationService
        );
    }

    @Test
    public void test_JavaServiceResult_createUser_BAD_REQUEST_loginAlreadyExist() {

        User newUser = TestHelper.userFactory(null, "loginExist", "l3g@lPwd", "l3g@lPwd", "toto@toto.fr");

        boolean exception = false;

        try {
            service.createUser(newUser);
        } catch (ServiceException e) {
            exception = true;
            Assert.assertNotNull(e);
            Assert.assertEquals(Http.Status.BAD_REQUEST, e.getHttpStatus());
        }

        Assert.assertTrue("exception should be true", exception);
    }

    @Test
    public void test_JavaServiceResult_createUser_BAD_REQUEST_emailAlreadyExist() {

        User newUser = TestHelper.userFactory(null, "totoLogin", "l3g@lPwd", "l3g@lPwd", "emailexist@toto.fr");

        boolean exception = false;
        try {
            service.createUser(newUser);
        } catch (ServiceException e) {
            exception = true;
            Assert.assertNotNull(e);
            Assert.assertEquals(Http.Status.BAD_REQUEST, e.getHttpStatus());
        }

        Assert.assertTrue("exception should be true", exception);
    }

    @Test
    public void test_JavaServiceResult_createUser_CREATED() {

        User newUser = TestHelper.userFactory(null, "totoLogin", "l3g@lPwd", "l3g@lPwd", "toto@toto.fr");

        JavaServiceResult res = null;
        try {
            res = service.createUser(newUser);
        } catch (ServiceException e) {
            Assert.fail();
        }

        Assert.assertNotNull(res);
        Assert.assertEquals(Http.Status.CREATED, res.getHttpStatus());
    }

    @Test
    public void test_JavaServiceResult_createUser_BAD_REQUEST_badPasswords() {

        User newUser = TestHelper.userFactory(null, "totoLogin", "l3g@lPwd", "l3g@lPwdNotMatching", "toto@toto.fr");

        boolean exception = false;
        try {
            service.createUser(newUser);
        } catch (ServiceException e) {
            exception = true;
            Assert.assertNotNull(e);
            Assert.assertEquals(Http.Status.BAD_REQUEST, e.getHttpStatus());
        }

        Assert.assertTrue("exception should be true", exception);
    }
}
