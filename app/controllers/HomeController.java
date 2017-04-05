package controllers;

import play.api.Environment;
import play.mvc.*;
import play.data.*;
import play.db.ebean.Transactional;


import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

import views.html.*;

// import models
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


	public Result index()
	{
		return ok(index.render());
	}

        public Result fuelLevels()
	{
		return ok(fuelLevels.render());
	}

	public Result orderFuel()
	{
		return ok(orderFuel.render());
	}
	
	public Result setFuelPrices()
	{
		return ok(setFuelPrices.render());
	}

	public Result reports()
	{
		return ok(reports.render());
	}

	public Result barChart()
	{
		return ok(barChart.render());
	}

	public Result pieChart()
	{
		return ok(pieChart.render());
	}

	public Result lineChart()
	{
		return ok(lineChart.render());
	}

	public Result roster()
	{
		return ok(roster.render());
	}
	public Result rewardMembers()
	{
		return ok(rewardMembers.render());
	}



}








































