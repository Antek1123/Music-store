package antoni.podebski.musicstore.operator.model;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "operator_to_role")
@IdClass(OperatorToRoleId.class)
public class OperatorToRole {

	@Id
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "operator_id")
	private Operator operator;

	@Id
	@Access(AccessType.PROPERTY)
	@Enumerated(EnumType.STRING)
	private OperatorRoleName role;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public OperatorRoleName getRole() {
		return role;
	}

	public void setRole(OperatorRoleName name) {
		this.role = name;
	}

}
