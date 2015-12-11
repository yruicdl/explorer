package httpclient;

import java.io.File;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @author zhengchunxi 2015年11月12日 下午6:29:36
 */
public class HttpUtils2 {

	private String charset = "UTF-8";
	private String contentType = "application/json";

	private CloseableHttpClient httpClient = HttpClients.createDefault() ;
	private CloseableHttpResponse httpResponse = null;
	private HttpEntity entity; 
	
	/**
	 * 发送Get请求
	 * @param url : 请求的URL
	 * @return response :返回的HttpResponse
	 * @throws IOException 
	 */
	public CloseableHttpResponse doGet(String url) throws IOException {
		//add trim to Removing leading and trailing whitespace from url 
		HttpGet httpGet = new HttpGet(url.trim());
		httpResponse = execute(httpGet);
		return httpResponse;
	}

	/***
	 * 发送POST请求,charset="utf-8",contentType = "application/json"
	 * @param url : 接口url
	 * @param params : 接口参数，由于contentType = "application/json"，因此参数需要符合json格式
	 * @return 返回的HttpResponse
	 * @throws IOException 
	 */
	public CloseableHttpResponse doPost(String url, String params) throws IOException {
		HttpPost post = new HttpPost(url.trim());
		entity = setHttpEntity(post, PostType.body, params, null);
		post.setEntity(entity);
		httpResponse = execute(post);
		return httpResponse;
	}
	
	/**
	 * @param url : 接口url
	 * @param params : 接口参数，由于contentType = "application/json"，因此参数需要符合json格式
	 * @param filePath
	 * @return
	 * @throws IOException 
	 */
	public CloseableHttpResponse doPost(String url, String params, String filePath) throws IOException {
//	//add trim to Removing leading and trailing whitespace from url 
		HttpPost httpPost = new HttpPost(url.trim());
		entity = setHttpEntity(httpPost, PostType.file, params, filePath);
		httpPost.setEntity(entity);
		httpResponse = execute(httpPost);
		return httpResponse;          
	}
	
	public CloseableHttpResponse doPut(String url,String params) throws IOException {
		//add trim to Removing leading and trailing whitespace from url 
		HttpPut httpPut = new HttpPut(url.trim());
		entity = setHttpEntity(httpPut, PostType.body, params, null);
		httpPut.setEntity(entity);
		return execute(httpPut);
	}
	
	public CloseableHttpResponse doPut(String url,String params,String filePath) throws IOException {
		//add trim to Removing leading and trailing whitespace from url 
		HttpPut httpPut = new HttpPut(url.trim());
		entity = setHttpEntity(httpPut, PostType.body, params, filePath);
		httpPut.setEntity(entity);
		return execute(httpPut);
	}
	
	public CloseableHttpResponse doDelete(String url) throws IOException {
		//add trim to Removing leading and trailing whitespace from url 
		HttpDelete httpDelete = new HttpDelete(url.trim());
		return execute(httpDelete);
	}
	
	/**
	 * @param response : 接口返回的HttpResponse
	 * @return 取出response的body部分,会关闭response
	 * @throws IOException 
	 */
	public String getResponseContent(CloseableHttpResponse httpResponse) throws IOException {
		String responseContent = null;
		entity = httpResponse.getEntity();
		try {
			responseContent = EntityUtils.toString(entity, charset);
			EntityUtils.consume(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			httpResponse.close();
		}
		return responseContent;
	}

	/**
	 * 组装HttpEntity参数
	 * @param method
	 * @param postType
	 * @param params
	 * @param filePath
	 * @return
	 */
	private HttpEntity setHttpEntity(HttpRequestBase method,PostType postType, String params, String filePath){
		HttpEntity entry = null;
		if (postType.equals(PostType.body)) { // If post parameters type is "body"
			method.setHeader("Content-Type", contentType);
			method.setHeader("Accept", contentType);
			entry = new StringEntity(params.toString(), charset);
		} else if (postType.equals(PostType.path)) { // If post parameters type is "path"
			// do nothing
		} else if (postType.equals(PostType.file)) { // If post parameters type is "file"
			String[] paths = filePath.split(";");
			MultipartEntityBuilder builder = MultipartEntityBuilder.create();
			for (int i = 0; i < paths.length; i++) {
				FileBody bin = new FileBody(new File(paths[i]), ContentType.MULTIPART_FORM_DATA);
				builder.addPart("bin", bin);
			}
			entry = builder.build();
		}
		return entry;
	}
	
	/**
	 * 执行请求，拿到返回的CloseableHttpResponse
	 * @param method
	 * @return
	 * @throws IOException
	 */
	private CloseableHttpResponse execute(HttpRequestBase method) throws IOException{
		try {
			httpResponse = httpClient.execute(method);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		return httpResponse;
	}
	
	public void closeHttpClient() throws IOException{
		if (httpClient != null) {
			httpClient.close();
		}
	}
}
