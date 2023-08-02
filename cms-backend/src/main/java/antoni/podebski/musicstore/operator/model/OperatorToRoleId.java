package antoni.podebski.musicstore.operator.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class OperatorToRoleId implements Serializable {

	@Serial
	private static final long serialVersionUID = 1234907983174012341L;

	public long operator;

	public OperatorRoleName role;

	public long getOperator() {
		return operator;
	}

	public void setOperator(long operator) {
		this.operator = operator;
	}

	public OperatorRoleName getRole() {
		return role;
	}

	public void setRole(OperatorRoleName role) {
		this.role = role;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		final OperatorToRoleId that = (OperatorToRoleId) o;
		return operator == that.operator && role == that.role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(operator, role);
	}

}
