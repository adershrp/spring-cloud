/**
 *
 */
package hello;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Adersh.P
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {
	/**
	 *
	 */
	private int id;
	private String message;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Greeting [id=" + id + ", message=" + message + "]";
	}

}
