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



	// ------------------- FUEL LEVELS ---------------------------------------------------------
        public Result fuelLevels() {

		List<Tank> tankList = Tank.findAll();


		return ok(fuelLevels.render(tankList, getUserFromSession()));
	}
	// ------------------- FUEL ORDER & UPDATE FUEL ORDER ---------------------------------------
	@Transactional
	public Result updateTank(Long id) {

		Tank t;
		Form<Tank> TankForm;

		try {
			t = Tank.find.byId(id);

			TankForm = formFactory.form(Tank.class).fill(t);

		} catch (Exception ex) {

			return badRequest("error");
		}
		return ok(newFuelOrder.render(TankForm, getUserFromSession()));
	}
	public Result orderFuel()
	{
		List<Tank> tankList = Tank.findAll();

		return ok(orderFuel.render(tankList,getUserFromSession()));
	}

	public Result newFuelOrder(){

		Form<Tank> newFuelOrderForm = formFactory.form(Tank.class);

		return ok(newFuelOrder.render(newFuelOrderForm,getUserFromSession()));
	}



	public Result newFuelOrderSubmit(){

		Form<Tank> newFuelOrderForm = formFactory.form(Tank.class).bindFromRequest();

		if(newFuelOrderForm.hasErrors()){

			return badRequest(newFuelOrder.render(newFuelOrderForm,getUserFromSession()));
		}

		Tank t = newFuelOrderForm.get();

		if(t.getId() == 0){
			t.save();
		}

		else if(t.getId() !=0){
			t.update();
		}

		flash("success", "Fuel Order for" + t.getName() + "has been processed");

		return redirect(controllers.routes.HomeController.orderFuel());
	}

	// --------------------------- REPORTS ---------------------------------------------------------
	public Result reports()
	{
		return ok(reports.render(getUserFromSession()));
	}

	public Result reportsAllSales(){

		List<AllSales> allSalesList = AllSales.findAll();

		return ok(reportsAllSales.render(allSalesList,getUserFromSession()));}

	public Result reportsDiesel(){

		List<DieselSale> dieselSaleList= DieselSale.findAll();

		return ok(reportsDiesel.render(dieselSaleList, getUserFromSession()));}

	public Result reportsUnleaded(){

		List<UnleadedSale> unleadedSaleList = UnleadedSale.findAll();

		return ok(reportsUnleaded.render(unleadedSaleList,getUserFromSession()));}

	// --------------------------- CHARTS ------------------------------------------------------------

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

	// ---------------------------- ROSTER ----------------------------------------------------------

	public Result roster()
	{
		return ok(roster.render(getUserFromSession()));
	}

	// ----------------------------- PROFILE --------------------------------------------------------

        public Result profile()
	{
		return ok(profile.render(getUserFromSession()));
	}

	// ---------------------------- REWARD MEMBERS ---------------------------------------------------

	public Result rewardMembers() {
		// Get the list of members
		List<RewardMember> rewardMemberList = RewardMember.findAll();

		// render the list members view, passing parameters
		return ok(rewardMembers.render(rewardMemberList, getUserFromSession()));}

                
	// ---------------------------- UPDATE FUEL PRICES -------------------------------------------------
                @Transactional
         	public Result updateFuelPrices(Long id) {

                FuelPrice f;
                Form<FuelPrice> fuelPriceForm;

                try{
                     f=FuelPrice.find.byId(id);
            
                     fuelPriceForm = formFactory.form(FuelPrice.class).fill(f);
    
                } catch(Exception ex) {
    
                     return badRequest("error");
                }
		return ok(addPrices.render(fuelPriceForm,getUserFromSession()));
	}


         public Result setFuelPrices() {


		List<FuelPrice> fuelPriceList = FuelPrice.findAll();
                
		return ok(setFuelPrices.render(fuelPriceList,getUserFromSession()));
	}



        public Result addPrices() {
                
                   Form<FuelPrice> addFuelPricesForm = formFactory.form(FuelPrice.class);

		return ok(addPrices.render(addFuelPricesForm,getUserFromSession()));
	}

        private FormFactory formFactory;
      
        @Inject
        public HomeController(FormFactory f) {

			this.formFactory=f;
        }

        public Result addFuelPricesSubmit(){

            Form<FuelPrice> newFuelPricesForm = formFactory.form(FuelPrice.class).bindFromRequest();

            if(newFuelPricesForm.hasErrors()){

            return badRequest(addPrices.render(newFuelPricesForm,getUserFromSession()));

			}

			FuelPrice f = newFuelPricesForm.get();

        if (f.getId() == 0) {

            f.save();
         }

         else if(f.getId() != 0) {

            f.update();
         }

          flash("success", "Fuel Price " +f.getName() + " has been created/updated");

			return redirect(controllers.routes.HomeController.setFuelPrices());

	}

        public Result addMember() {
                
                   Form<RewardMember> addMemberForm = formFactory.form(RewardMember.class);

		return ok(addMember.render(addMemberForm,getUserFromSession()));
	}


        public Result addMemberSubmit(){

            Form<RewardMember> newMemberForm = formFactory.form(RewardMember.class).bindFromRequest();



            if(newMemberForm.hasErrors()){

            return badRequest(addMember.render(newMemberForm,getUserFromSession()));

	}



         RewardMember r = newMemberForm.get();



        if (r.getId() == null) {

            r.save();

         }

         else if(r.getId() != null) {

            r.update();

         }



          flash("success", "Member " +r.getName() + " has been created/updated");



          return redirect(controllers.routes.HomeController.rewardMembers());



          }

          public Result deleteMember(Long id) {

          RewardMember.find.ref(id).delete();
          flash("success", "Member has been deleted");
 
          return redirect(routes.HomeController.rewardMembers());


          }
          
           @Transactional
         	public Result updateMember(Long id) {

                RewardMember r;
                Form<RewardMember> MemberForm;

                try{
                     r=RewardMember.find.byId(id);
            
                     MemberForm = formFactory.form(RewardMember.class).fill(r);
    
                } catch(Exception ex) {
    
                     return badRequest("error");
                }
		return ok(addMember.render(MemberForm,getUserFromSession()));
	}


        


}




































