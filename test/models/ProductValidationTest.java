package models;


import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.myweb.db.TestHelper;
import play.data.Form;
import play.data.validation.ValidationError;
import play.libs.Json;

import java.util.List;
import java.util.Map;

public class ProductValidationTest {

    Product validProduct;

    @Before
    public void setUp() throws Exception {

        validProduct = TestHelper.productFactory(null, "boubouboubou", null, 10, 10l, null);
    }

    @Test
    public void testProductValidation_OK() {

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertFalse(productForm.hasErrors());
    }

    @Test
    public void testProductValidation_KO_requiredFields() {

        //noinspection ConstantConditions
        validProduct.setName(null);
        //noinspection ConstantConditions
        validProduct.setNumberInteger(null);
        //noinspection ConstantConditions
        validProduct.setCategory(null);

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertTrue(productForm.hasErrors());

        Map<String,List<ValidationError>> errors = productForm.errors();
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);

        List<ValidationError> fieldErrors;
        ValidationError fieldError;

        fieldErrors = errors.get("name");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.required", fieldError.message());

        fieldErrors = errors.get("numberInteger");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.required", fieldError.message());
    }

    @Test
    public void testProductValidation_KO_stringsMinLengths() {

        validProduct.setName("toto");

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertTrue(productForm.hasErrors());

        Map<String,List<ValidationError>> errors = productForm.errors();
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);

        List<ValidationError> fieldErrors;
        ValidationError fieldError;

        fieldErrors = errors.get("name");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.minLength", fieldError.message());

        validProduct.setName("totototototototototototototototototototototototototototototototototototo");
    }

    @Test
    public void testProductValidation_KO_stringsMaxLengths() {

        validProduct.setName("totototototototototototototototototototototototototototototototototototo");

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertTrue(productForm.hasErrors());

        Map<String,List<ValidationError>> errors = productForm.errors();
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);

        List<ValidationError> fieldErrors;
        ValidationError fieldError;

        fieldErrors = errors.get("name");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.maxLength", fieldError.message());
    }

    @Test
    public void testProductValidation_KO_numericMin() {

        validProduct.setNumberInteger(0);
        validProduct.setNumberLong(9l);

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertTrue(productForm.hasErrors());

        Map<String,List<ValidationError>> errors = productForm.errors();
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);

        List<ValidationError> fieldErrors;
        ValidationError fieldError;

        fieldErrors = errors.get("numberInteger");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.min", fieldError.message());

        fieldErrors = errors.get("numberLong");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.min", fieldError.message());
    }

    @Test
    public void testProductValidation_KO_numericMax() {

        validProduct.setNumberInteger(11);
        validProduct.setNumberLong(21l);

        JsonNode jsProduct = Json.toJson(validProduct);

        Form<Product> productForm = Form.form(Product.class);
        productForm = productForm.bind(jsProduct);

        Assert.assertTrue(productForm.hasErrors());

        Map<String,List<ValidationError>> errors = productForm.errors();
        Assert.assertNotNull(errors);
        Assert.assertTrue(errors.size() > 0);

        List<ValidationError> fieldErrors;
        ValidationError fieldError;

        fieldErrors = errors.get("numberInteger");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.max", fieldError.message());

        fieldErrors = errors.get("numberLong");
        Assert.assertNotNull(fieldErrors);
        Assert.assertTrue(fieldErrors.size() > 0);
        fieldError = fieldErrors.get(0);
        Assert.assertEquals("error.max", fieldError.message());
    }
}
