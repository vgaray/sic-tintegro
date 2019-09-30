/**
 * 
 */
package pe.com.tintegro.dto.response;

import java.util.List;

import pe.com.tintegro.dominio.Plan;

/**
 * @author FReyes
 *
 */
public class ListarPlanResponse extends ResponseBase
{
	private List<Plan> listPlan;

	public List<Plan> getListPlan() {
		return listPlan;
	}

	public void setListPlan(List<Plan> listPlan) {
		this.listPlan = listPlan;
	}
	
	
}
