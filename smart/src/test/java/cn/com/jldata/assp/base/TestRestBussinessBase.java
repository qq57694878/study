package cn.com.jldata.assp.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.springframework.http.HttpHeaders;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.operation.OperationRequest;
import org.springframework.restdocs.operation.OperationRequestFactory;
import org.springframework.restdocs.operation.OperationResponse;
import org.springframework.restdocs.operation.OperationResponseFactory;
import org.springframework.restdocs.operation.preprocess.OperationPreprocessor;
import org.springframework.restdocs.operation.preprocess.OperationPreprocessorAdapter;
import org.springframework.restdocs.operation.preprocess.Preprocessors;
import org.springframework.restdocs.restassured3.RestDocumentationFilter;
import org.springframework.restdocs.templates.TemplateFormats;

import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.document;
import static org.springframework.restdocs.restassured3.RestAssuredRestDocumentation.documentationConfiguration;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 业务测试基类
 */
public class TestRestBussinessBase extends TestRestBase{
    protected ObjectMapper objectMapper = new ObjectMapper();
    protected String token;
    protected RequestSpecification spec;
    private final String TOKEN ="token";

    private RestDocumentationFilter documentationFilter;
    // 执行测试方法之前初始化模拟request,response
    @Rule
    public JUnitRestDocumentation restDocumentation = new JUnitRestDocumentation();
    @Before
    public void init() throws Exception {
        super.init();
        //this.getToken();
        setUp();
    }




    public void getToken()throws Exception {
        this.token="7c9f0b20-e175-40a2-8cf1-bb7a1d3a11da";
    }
/*    public void setUp() {
        final String token1 = this.token;
        this.documentationFilter = document("{ClassName}/{methodName}",
                preprocessRequest(),preprocessResponse(prettyPrint()));
        this.spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(this.restDocumentation)
                        .snippets().withEncoding("UTF-8")).addFilter(documentationFilter).setContentType(ContentType.URLENC)
                .build();
        //this.spec = new RequestSpecBuilder().addFilter(documentationConfiguration(this.restDocumentation).snippets().withTemplateFormat(TemplateFormats.markdown())).build();
    }*/

    public void setUp() {
        final String token1 = this.token;
        this.documentationFilter = document("{className}/{methodName}",
                preprocessRequest(new OperationPreprocessorAdapter() {
                   private final OperationRequestFactory requestFactory = new OperationRequestFactory();
                    @Override
                    public OperationRequest preprocess(OperationRequest request) {
                        return requestFactory.createFrom(request, this.addHeaders(request.getHeaders()));
                    }
                    private HttpHeaders addHeaders(HttpHeaders originalHeaders) {
                        HttpHeaders processedHeaders = new HttpHeaders();
                        processedHeaders.putAll(originalHeaders);
                        if(!processedHeaders.containsKey(TOKEN)){
                            processedHeaders.add(TOKEN,token1);
                        }
                        return processedHeaders;
                    }
                }),preprocessResponse(new OperationPreprocessorAdapter() {
                    private final OperationResponseFactory responseFactory = new OperationResponseFactory();
                    private  ObjectMapper objectMapper = new ObjectMapper();
                    @Override
                    public OperationResponse preprocess(OperationResponse response){

                        byte[] modifiedContent = new byte[0];
                        try {
                            modifiedContent = this.objectMapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(objectMapper.readTree(response.getContent()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return this.responseFactory.createFrom(response, modifiedContent);
                    }
                }));
        this.spec = new RequestSpecBuilder()
                .addFilter(documentationConfiguration(this.restDocumentation)
                        .snippets().withEncoding("UTF-8")).addFilter(documentationFilter).setContentType(ContentType.URLENC)
                .build();
        //this.spec = new RequestSpecBuilder().addFilter(documentationConfiguration(this.restDocumentation).snippets().withTemplateFormat(TemplateFormats.markdown())).build();
    }

}
