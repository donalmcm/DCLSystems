package controllers;

import play.mvc.*;

import java.util.List;

import views.html.*;
// import models
import models.users.User;
import models.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

        private User getUserFromSession() {

	  return User.getUserById(session().get("email"));

         }


	public Result index()
	{
		return ok(index.render(getUserFromSession()));
	}

        public Result fuelLevels()
	{
		return ok(fuelLevels.render(getUserFromSession()));
	}

	public Result orderFuel()
	{
		return ok(orderFuel.render(getUserFromSession()));
	}
	
	public Result setFuelPrices()
	{
		return ok(setFuelPrices.render(getUserFromSession()));
	}

	public Result reports()
	{
		return ok(reports.render(getUserFromSession()));
	}

	public Result reportsAllSales(){return ok(reportsAllSales.render(getUserFromSession()));}

	public Result reportsDiesel(){

		List<DieselSale> dieselSaleList= DieselSale.findAll();

		return ok(reportsDiesel.render(dieselSaleList, getUserFromSession()));}

	public Result reportsUnleaded(){

		List<UnleadedSale> unleadedSaleList = UnleadedSale.findAll();

		return ok(reportsUnleaded.render(unleadedSaleList,getUserFromSession()));}

	public Result barChart()
	{
		return ok(barChart.render(getUserFromSession()));
	}

	public Result pieChart()
	{
		return ok(pieChart.render(getUserFromSession()));
	}

	public Result lineChart()
	{
		return ok(lineChart.render(getUserFromSession()));
	}

	public Result roster()
	{
		return ok(roster.render(getUserFromSession()));
	}

	public Result rewardMembers() {
		// Get the list of members
		List<RewardMember> rewardMemberList = RewardMember.findAll();

		// render the list members view, passing parameters
		return ok(rewardMembers.render(rewardMemberList, getUserFromSession()));}

}




































