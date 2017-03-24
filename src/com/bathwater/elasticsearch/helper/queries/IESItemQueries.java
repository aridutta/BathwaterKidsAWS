package com.bathwater.elasticsearch.helper.queries;

import java.io.IOException;
import java.util.List;

public interface IESItemQueries {

	List<String> searchItems(List<String> keywords) throws IOException;

	List<String> itemSuggest(String text);

}
