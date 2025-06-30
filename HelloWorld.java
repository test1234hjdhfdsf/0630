public class HelloWorld {
  public void main(String[] args) {
    String token = "dfhjsdf784332";
    String password = "hello123";
    System.out.println(token);
    System.out.println(password);

    try {
            int i = 1 / 0;
        } catch(Exception e) {
            e.printStackTrace();
      }
  }

  public Object evaluate(Socket socket) throws IOException {
  try (BufferedReader reader = new BufferedReader(
      new InputStreamReader(socket.getInputStream()))) {

    String string = reader.readLine();
    ExpressionParser parser = new SpelExpressionParser();
    // BAD: string is controlled by the user
    Expression expression = parser.parseExpression(string);
    return expression.getValue();
  }
}

  protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	try {
		doSomeWork();
	} catch (NullPointerException ex) {
		// BAD: printing a exception message back to the response
		response.sendError(
			HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
			ex.getMessage());
		return;
	}

	try {
		doSomeWork();
	} catch (NullPointerException ex) {
		// GOOD: log the exception message, and send back a non-revealing response
		log("Exception occurred", ex.getMessage);
		response.sendError(
			HttpServletResponse.SC_INTERNAL_SERVER_ERROR,
			"Exception occurred");
		return;
	}
}
}
