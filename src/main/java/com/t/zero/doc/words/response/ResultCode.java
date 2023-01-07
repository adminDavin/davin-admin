package com.t.zero.doc.words.response;

public interface ResultCode {
	int CODE_ERROR = 400;
	int CODE_NOTFOUND = 404;
	int CODE_UNSUPPORTED = 403;
	int CODE_FORBIDDEN = 401;

	int CODE_SERVER = 500;

	String RESPONSE_SUCCESS = "{\"Code\":200,\"Message\":\"successful\"}";
	String RESPONSE_INTERNAL_FAILURE = "{\"HttpStatusCode\":500,\"Code\":\"InternalFailure\",\"Message\":\"The request processing has failed due to some unknown error, exception or failure.\"}";
	String RESPONSE_EXTERNAL_FAILURE = "{\"HttpStatusCode\":500,\"Code\":\"ExternalFailure\",\"Message\":\"The request processing has failed due to external service failure.\"}";

}
